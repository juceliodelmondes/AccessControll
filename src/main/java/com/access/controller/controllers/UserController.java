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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public CommandResponseObject validate(@RequestBody ValidationRequestObject information) {
        return user.validateAccess(information);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestBody RegisterUserRequestObject information) {
        System.out.println("Registrando usuário");
        return user.register(information);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody DeleteUserRequestObject information) {
        user.delete(information); 
    }
    
    @RequestMapping(value = "/uploadpicture", method = RequestMethod.POST)
    public void uploadPicture(@RequestParam MultipartFile picture) {
        
    }
    
    @RequestMapping(value = "/searchuseraccess", method = RequestMethod.GET)
    public UserAccessResponseObject searchUserAccess() {
        return user.searchUserAccess();
    }
}
