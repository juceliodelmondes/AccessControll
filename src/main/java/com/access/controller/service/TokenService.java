/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import java.util.Random;

/**
 *
 * @author Jucelio
 */
public class TokenService {
    private final String charAllowedToken = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int tokenLength = 512;
    /**
     * Gera um token
     * @return retorna o token gerado
     */
    public String generateToken() {
        String finalToken = "";
        Random random = new Random();
        for(int i = 0; i < tokenLength; i++) {
            finalToken += charAllowedToken.charAt(random.nextInt(charAllowedToken.length()));
        }
        return finalToken;
    }
}
