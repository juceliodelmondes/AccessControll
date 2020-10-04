/*
Objeto de resposta após a validação da biometria
*/
package com.access.controller.responseObject;

/**
 *
 * @author Jucelio
 */
public class CommandResponseObject {
    
    private String command; //comando 
    private int commandParameter; //Parâmetro do comando      
    private String textSpeech; //texto para a fala no csharp
    
    public String getCommand() {
        return this.command;
    }
    
    public void setCommand(String command) {
        this.command = command;
    }
    
    public int getCommandParameter() {
        return this.commandParameter;
    }
    
    public void setCommandParameter(int parameter) {
        this.commandParameter = parameter;
    }
    
    public String getTextSpeech() {
        return this.textSpeech;
    }
    
    public void setTextSpeech(String textSpeech) {
        this.textSpeech = textSpeech;
    }
    
}
