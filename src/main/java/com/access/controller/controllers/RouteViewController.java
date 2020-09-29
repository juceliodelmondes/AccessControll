/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controla as rodas do front-end
 * @author Jucelio
 */
@RestController
public class RouteViewController {
    /**
     * Retorna a página de monitoramento de usuários
     * @return 
     */
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    /**
     * Retorna a página de controle de usuários
     * @return 
     */
    @GetMapping("/user")
    public ModelAndView user() {
        return new ModelAndView("user");
    }
}
