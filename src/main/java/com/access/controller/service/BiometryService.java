/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import com.access.controller.models.UserModel;
import com.access.controller.repository.UserRepository;
import com.access.controller.requestResponseObject.RegisterBiometryRequestResponse;
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
    public RegisterBiometryRequestResponse register(RegisterBiometryRequestResponse information) {
        UserModel user = repo.findByName(information.getName());
        RegisterBiometryRequestResponse response = new RegisterBiometryRequestResponse();
        if(user != null) {
            user.setIdBiometry(0);
            user.setRecordedBiometry(false);
            try {
                if(repo.save(user) != null) {
                    for(int i = 1; i < 150; i++) {
                        if(repo.findByIdBiometry(i) == null) {
                            user.setIdBiometry(i);
                            user = repo.save(user);
                            CommandResponseObject commandResponse = new CommandResponseObject();
                            commandResponse.setCommand(command.registerUser);
                            commandResponse.setCommandParameter(i);
                            command.newCommand(commandResponse);
                            response.setIdBiometry(user.getIdBiometry());
                            response.setName(user.getName());
                            break;
                        }
                    }
                }
            } catch (Exception er) {
                System.out.println(er.getMessage());
            }
        }
        return response;
    }
    
    /**
     * Captura e retorna o status atual
     * @param information
     * @return 
     */
    public StatusBiometryRequestResponse registerStatus(StatusBiometryRequestResponse information) {
        StatusBiometryRequestResponse statusResponse = new StatusBiometryRequestResponse();
        for(StatusBiometryRequestResponse result : registerStatus) {
            if(result.getIdBiometry() == information.getIdBiometry()) {
                statusResponse = result;
                System.out.println(result.getStatus()); 
            }
        }
        registerStatus.removeIf(obj -> obj.getStatus().equals(command.recorded) || obj.getStatus().equals(command.error));
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
            /**
             * Caso o arduino informe que a biometria foi gravada com sucesso!
             * Ou caso o arduino informe que ocorreu algum erro
             */
            if(information.getStatus().equals(command.recorded) || information.getStatus().equals(command.error)) {
                UserModel user = repo.findByIdBiometry(information.getIdBiometry());
                if(user != null) {
                    try {
                        if(information.getStatus().equals(command.recorded)) user.setRecordedBiometry(true);
                        if(information.getStatus().equals(command.error)) {
                            user.setIdBiometry(0);
                            user.setRecordedBiometry(false);
                        }
                        repo.save(user);
                    } catch (Exception er) {}
                }
            }
        }
    }
}