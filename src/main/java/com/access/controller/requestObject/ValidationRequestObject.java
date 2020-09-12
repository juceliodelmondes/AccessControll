/*
Objeto de requisicao quando um usuário digitalizar sua biometria.
*/
package com.access.controller.requestObject;

/**
 *
 * @author Jucelio
 */
public class ValidationRequestObject {
    private int id;
    private int confidence;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getConfidence() {
        return this.confidence;
    }
    
    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }
}
