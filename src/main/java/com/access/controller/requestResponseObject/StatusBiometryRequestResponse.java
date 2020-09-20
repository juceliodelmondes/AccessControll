/**
 * Classe que será utilizada para requisicao e resposta
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
