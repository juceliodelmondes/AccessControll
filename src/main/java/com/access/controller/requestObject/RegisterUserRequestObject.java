/*
Classe Objeto para a requisição de cadastro de novo usuário
*/
package com.access.controller.requestObject;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jucelio
 */
public class RegisterUserRequestObject {
    private String name;
    private boolean access;
    private MultipartFile image;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean getAccess() {
        return this.access;
    }
    
    public void setAccess(boolean access) {
        this.access = access;
    }
    
    public MultipartFile getImage() {
        return this.image;
    }
    
    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
