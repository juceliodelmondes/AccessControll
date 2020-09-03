/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.controllers;

import com.access.controller.models.UserModel;
import com.access.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jucelio
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserRepository repo;
    
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public void validate() {
        System.out.println("Validando usuario");
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register() {
        System.out.println("Registrando usuário");
    }
}
