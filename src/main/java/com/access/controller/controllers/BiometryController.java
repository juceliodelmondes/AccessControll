/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.controllers;

import com.access.controller.requestObject.RegisterUserRequestObject;
import com.access.controller.requestResponseObject.StatusBiometryRequestResponse;
import com.access.controller.service.BiometryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jucelio
 */
@CrossOrigin
@RestController
@RequestMapping("/biometry")
public class BiometryController {
    
    @Autowired
    BiometryService bio;
    /**
     * Registra uma nova biometria
     * @param information
     * @return 
     */
    @PostMapping("/register")
    public boolean register(@RequestBody RegisterUserRequestObject information) {
        return bio.register(information);
    }
    
    /**
     * Retorna o status atual de registro um determinado usuário
     * @param information
     * @return 
     */
    @GetMapping("/registerStatus")
    public StatusBiometryRequestResponse status(@RequestBody StatusBiometryRequestResponse information) {
        return bio.registerStatus(information);
    }
    
    /**
     * Altera o status atual de registro de um determinado usuário
     * @param information 
     */
    @PostMapping("/setRegisterStatus")
    public void setStatus(@RequestBody StatusBiometryRequestResponse information) {
        bio.setRegisterStatus(information); 
    }
}
