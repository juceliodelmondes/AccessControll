/*
Objeto que devolve informação de acesso atual. (nome, foto url, acesso liberaod ou nao)
Este objeto é enviado para a tela quando um usuário validar na biometria
*/
package com.access.controller.responseObject;

/**
 *
 * @author Jucelio
 */
public class UserAccessResponseObject {
    private String name;
    private boolean access;
    private String token;
    
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
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
}
