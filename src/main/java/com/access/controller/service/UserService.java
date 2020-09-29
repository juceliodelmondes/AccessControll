/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import com.access.controller.models.UserModel;
import com.access.controller.repository.UserRepository;
import com.access.controller.requestObject.DeleteUserRequestObject;
import com.access.controller.requestObject.RegisterUserRequestObject;
import com.access.controller.requestObject.ValidationRequestObject;
import com.access.controller.responseObject.CommandResponseObject;
import com.access.controller.responseObject.UserAccessResponseObject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Jucelio
 */
@Service
public class UserService {
    
    private List<UserAccessResponseObject> usersAccess = new ArrayList<>();
    
    @Autowired
    UserRepository repo;
    
    @Autowired
    CommandService command;   
    
    @Autowired
    TokenService token;
    
    @Autowired
    ImageService image;
    
    /**
     * Valida o Id (leitor) com o banco de dados com o tipo de acesso
     * @param information
     * @return 
     */
    public CommandResponseObject validateAccess(ValidationRequestObject information) {
        System.out.println("Validando usuario");
        CommandResponseObject commandResponse = new CommandResponseObject();
        UserModel user = repo.findByIdBiometry(information.getId());
        if(user != null) {
            System.out.println("Usuário: "+user.getName()+" acesso: "+user.getAccess());
            UserAccessResponseObject newAccess = new UserAccessResponseObject();
            newAccess.setName(user.getName());
            newAccess.setAccess(user.getAccess());
            usersAccess.add(newAccess);
        } else { //caso tenha o dado gravado no sensor e não tiver no banco, remover do sensor
            commandResponse.setCommand(command.deleteUser);
            commandResponse.setCommandParameter(information.getId());
        }
        return commandResponse;
    }
    
    /**
     * Registra um novo usuário caso não exista
     * @param information
     * @return 
     */
    public boolean register(RegisterUserRequestObject information) {
        try {
            System.out.println("cadastrando "+information.getName());
            UserModel newUser = new UserModel();
            newUser.setName(information.getName());
            newUser.setAccess(information.getAccess()); 
            newUser.setToken(token.generateToken());          
            if(repo.save(newUser) != null) {
                image.saveImage(information, newUser);
                return true;
            } else return false;
            
        } catch (Exception er) {
            System.out.println(er);
            System.out.println(er.getMessage()); 
            System.out.println("Error");
        }
        return false;
    }
        
    /**
     * Deleta o usuario do bando de dados e do cadastro da biometria
     * @param information 
     */
    public void delete(DeleteUserRequestObject information) {
        UserModel user = repo.findByName(information.getName());
        if(user != null) {
            CommandResponseObject commandResponse = new CommandResponseObject();
            commandResponse.setCommand(command.deleteUser);
            commandResponse.setCommandParameter(user.getIdBiometry());
            command.newCommand(commandResponse);
            repo.deleteById(repo.findByName(information.getName()).getId());
        }
    }
    
    /**
     * Procura quais acessos que estão sendo validados no momento. (Para o front-end)
     * @return Objeto UserAccessResponseObject
     */
    public UserAccessResponseObject searchUserAccess() {
        UserAccessResponseObject userAccess = new UserAccessResponseObject();
        if(usersAccess.size() > 0) {
            userAccess = usersAccess.get(0);
            usersAccess.remove(0);
        }
        return userAccess;
    }
}
