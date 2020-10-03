package com.access.controller.requestResponseObject;

/**
 * Classe responsável pela requisicao de cadastro e devolucao de Id para o front end
 * @author Jucelio
 */
public class RegisterBiometryRequestResponse {
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
