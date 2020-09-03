/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jucelio
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public ModelAndView index() {
        System.out.println("INDEX"); 
        return new ModelAndView("index");
    }
}
