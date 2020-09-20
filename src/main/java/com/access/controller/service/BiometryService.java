/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import com.access.controller.models.UserModel;
import com.access.controller.repository.UserRepository;
import com.access.controller.requestObject.RegisterUserRequestObject;
import com.access.controller.requestResponseObject.StatusBiometryRequestResponse;
import com.access.controller.responseObject.CommandResponseObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jucelio
 */
@Service
public class BiometryService {
    private List<StatusBiometryRequestResponse> registerStatus = new ArrayList<>();
    
    @Autowired
    UserRepository repo;
    
    @Autowired
    CommandService command;
    /**
     * Registra uma nova biometria
     * @param information
     * @return 
     */
    public boolean register(RegisterUserRequestObject information) {
        UserModel user = repo.findByName(information.getName());
        if(user != null) {
            user.setIdBiometry(0);
            user.setRecordedBiometry(false);
            try {
                user = repo.save(user);
                if(user != null) {
                    int nextId = 0;
                    for(int i = 1; i < 150; i++) {
                        UserModel search = repo.findByIdBiometry(i);
                        if(search == null) {
                            nextId = i;
                            break;
                        }
                    }
                    if(nextId > 0) {
                        user.setIdBiometry(nextId);
                        user = repo.save(user);
                        CommandResponseObject commandResponse = new CommandResponseObject();
                        commandResponse.setCommand(command.registerUser);
                        commandResponse.setCommandParameter(nextId);
                        command.newCommand(commandResponse);                        
                        return user != null;
                    }
                }
            } catch (Exception er) {
                System.out.println(er.getMessage());
            }
        }
        return false;
    }
    
    /**
     * Captura e retorna o status atual
     * @param information
     * @return 
     */
    public StatusBiometryRequestResponse registerStatus(StatusBiometryRequestResponse information) {
        StatusBiometryRequestResponse statusResponse = new StatusBiometryRequestResponse();
        for(StatusBiometryRequestResponse result : registerStatus) {
            if(result.getIdBiometry() == information.getIdBiometry()) statusResponse = result;
        }
        registerStatus.removeIf(obj -> obj.getStatus().equals(command.gravado));
        return statusResponse;
    }
    
    /**
     * Seta o status atual de gravação
     * @param information 
     */
    public void setRegisterStatus(StatusBiometryRequestResponse information) {
        if(information.getStatus() != null && information.getIdBiometry() != 0) {
            boolean alteracao = false;
            for(StatusBiometryRequestResponse result : registerStatus) {
                if(result.getIdBiometry() == information.getIdBiometry()) {
                    result.setStatus(information.getStatus());
                    alteracao = true;
                }
            }
            if(alteracao == false) registerStatus.add(information);
        }
    }
}