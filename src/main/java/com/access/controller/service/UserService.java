/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import com.access.controller.models.UserModel;
import com.access.controller.repository.UserRepository;
import com.access.controller.requestObject.RegisterUserRequestObject;
import com.access.controller.requestObject.ValidationRequestObject;
import com.access.controller.responseObject.CommandResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jucelio
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository repo;
    
    /**
     * Valida o Id (leitor) com o banco de dados com o tipo de acesso
     * @param information
     * @return 
     */
    public CommandResponseObject validateAccess(ValidationRequestObject information) {
        System.out.println("Validando usuario");
        CommandResponseObject command = new CommandResponseObject();
        return command;
    }
    /**
     * Register realizará um cadastro de uma nova pessoa.
     * O algoritmo vai procurar o id biometria mais próximo para o novo usuário.
     * @param information
     * @return 
     */
    public boolean register(RegisterUserRequestObject information) {
        UserModel user = repo.findByName(information.getName());
        int idBiometry = 0;
        if(user == null) {
            for(int i = 0; i < 150; i++) {
                user = repo.findByIdBiometry(i);
                if(user == null) {
                    idBiometry = i;
                    break;
                }
            }
            if(user == null) {
                UserModel newUser = new UserModel();
                newUser.setName(information.getName());
                newUser.setAccess(information.getAccess());
                newUser.setIdBiometry(idBiometry);
                try {
                    newUser = repo.save(newUser);
                    return newUser != null;
                } catch (Exception er) { }
            }
        }
        return false;
    }
}
