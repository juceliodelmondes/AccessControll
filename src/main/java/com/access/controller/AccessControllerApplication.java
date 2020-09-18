package com.access.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessControllerApplication.class, args);
        System.out.println("Servidor iniciado!");
    }

}
