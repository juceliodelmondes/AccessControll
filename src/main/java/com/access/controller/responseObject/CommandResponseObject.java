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
}
