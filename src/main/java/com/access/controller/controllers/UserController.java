/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.controllers;

import com.access.controller.requestObject.DeleteUserRequestObject;
import com.access.controller.requestObject.RegisterUserRequestObject;
import com.access.controller.requestObject.ValidationRequestObject;
import com.access.controller.responseObject.CommandResponseObject;
import com.access.controller.responseObject.UserAccessResponseObject;
import com.access.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jucelio
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService user;
    /**
     * Requisição do CSharp para validar a biometria de um usuário
     * @param information
     * @return 
     */
    @PostMapping("/validate")
    public CommandResponseObject validate(@RequestBody ValidationRequestObject information) {
        return user.validateAccess(information);
    }
    /**
     * Registra um novo usuário
     * @param information
     * @return true em caso de sucesso
     */
    @PostMapping("/register")
    public boolean register(@RequestBody RegisterUserRequestObject information) {
        System.out.println("Registrando usuário "+information.getName());
        return user.register(information);
    }
    
    /**
     * Deleta um usuário
     * @param information 
     */
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteUserRequestObject information) {
        user.delete(information); 
    }
    
    /**
     * Recebe a foto e grava no diretorio
     * @param picture 
     */
    @PostMapping("/uploadpicture")
    public void uploadPicture(@RequestParam MultipartFile picture) {
        
    }
    
    /**
     * Retorna quais usuários que estão sendo validados no exato momento.
     * @return 
     */
    @GetMapping("/searchuseraccess")
    public UserAccessResponseObject searchUserAccess() {
        return user.searchUserAccess();
    }
}
