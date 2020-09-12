/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import com.access.controller.repository.UserRepository;
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
}
