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
}
