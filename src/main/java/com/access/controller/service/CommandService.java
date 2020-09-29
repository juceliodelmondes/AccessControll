package com.access.controller.service;

import com.access.controller.responseObject.CommandResponseObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jucelio
 */
@Service 
public class CommandService {
    //Lista de comandos padrões
    public final String registerUser = "w";
    public final String deleteUser = "d";
    
    
    //Gramáticas entre arduino e o spring no momento de gravação
    public final String recorded = "Recorded";
    public final String error = "Error";
    
    public List<CommandResponseObject> comandos = new ArrayList<>();
    
    /**
     * Adiciona novo comando para o Arduino executar.
     * @param command 
     */
    public void newCommand(CommandResponseObject command) {
        System.out.println("Novo comando: "+command.getCommand()+" "+command.getCommandParameter());
        comandos.add(command);
    }
    
    /**
     * Retorna qual o príxmo comando que o Arduino deverá executar
     * @return 
     */
    public CommandResponseObject getNextCommand() {
        CommandResponseObject command = new CommandResponseObject();
        if(comandos.size() > 0) {
            command = comandos.get(0);
            comandos.remove(0);
        }
        return command;
    }
}
