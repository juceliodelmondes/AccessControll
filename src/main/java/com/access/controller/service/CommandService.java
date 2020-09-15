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
    /**
     * Adiciona novo comando para o Arduino executar.
     * @param command 
     */
    public void newCommand(CommandResponseObject command) {
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
