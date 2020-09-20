/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.requestResponseObject;

/**
 *
 * @author Jucelio
 */
public class StatusBiometryRequestResponse {
    private int idBiometry;
    private String status;
    
    public int getIdBiometry() {
        return this.idBiometry;
    }
    
    public void setIdBiometry(int idBiometry) {
        this.idBiometry = idBiometry;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
