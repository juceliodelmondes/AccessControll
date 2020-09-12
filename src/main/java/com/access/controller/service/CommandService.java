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
    public List<CommandResponseObject> comandos = new ArrayList<>();
    
    public void newCommand(CommandResponseObject command) {
        comandos.add(command);
    }
    
    public CommandResponseObject getNextCommand() {
        System.out.println("Capturando próximo comando");
        CommandResponseObject command = new CommandResponseObject();
        if(comandos.size() > 0) {
            command = comandos.get(0);
            comandos.remove(0);
            System.out.println("Enviando comando "+command.getCommand());
        }
        return command;
    }
}
