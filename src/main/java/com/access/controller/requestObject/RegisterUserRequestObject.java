/*
Classe Objeto para a requisição de cadastro de novo usuário
*/
package com.access.controller.requestObject;

/**
 *
 * @author Jucelio
 */
public class RegisterUserRequestObject {
    private String name;
    private boolean access;
    private String image; //base 64
    
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
    
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
}
