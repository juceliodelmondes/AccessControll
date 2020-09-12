/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Jucelio
 */
@Entity
public class UserModel {
    
    @Id
    @GeneratedValue //gera um id automaticamente
    private int id;
    
    @Column(length = 60, unique = true)
    private String name;
    @Column(length = 255)
    private String token;
    @Column(length = 3)
    private int idBiometry;
    private boolean access;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public int getIdBiometry() {
        return this.idBiometry;
    }
    
    public void setIdBiometry(int idBiometry) {
        this.idBiometry = idBiometry;
    }
    
    public boolean getAccess() {
        return this.access;
    }
    
    public void setAccess(boolean access) {
        this.access = access;
    }
}
