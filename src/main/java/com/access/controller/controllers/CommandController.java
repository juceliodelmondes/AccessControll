
package com.access.controller.controllers;

import com.access.controller.responseObject.CommandResponseObject;
import com.access.controller.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jucelio
 */

@RestController
@RequestMapping("/command")
public class CommandController {
    
    @Autowired
    CommandService command;
    
    @RequestMapping(value = "/getCommand", method = RequestMethod.GET)
    public CommandResponseObject getCommand() {
        return command.getNextCommand();
    }
}
