/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.requestObject;

/**
 *
 * @author Jucelio
 */
public class DeleteUserRequestObject {
    private String name;
    private int idBiometry;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getIdBiometry() {
        return this.idBiometry;
    }
    
    public void setIdBiometry(int idBiometry) {
        this.idBiometry = idBiometry;
    }
}
