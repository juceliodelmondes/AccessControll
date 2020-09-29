/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.service;

import com.access.controller.models.UserModel;
import com.access.controller.requestObject.RegisterUserRequestObject;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jucelio
 */
@Service
public class ImageService {
    
    public void saveImage(RegisterUserRequestObject information, UserModel user) {
        new Thread(saveImageRunnable(information, user)).run();
    }
    
    private Runnable saveImageRunnable(RegisterUserRequestObject information, UserModel user) {
        return () -> {
            String[] b64 = information.getImage().split(",");
            byte[] result = Base64.decodeBase64(b64[1]);
            try {
                FileOutputStream stream = new FileOutputStream("src\\main\\resources\\static\\"+user.getToken()+".png");
                stream.write(result);
                stream.close();
                System.out.println("Salvando imagem para o usuario: "+user.getName());
            } catch (Exception er) {
                er.printStackTrace();
            } catch (Throwable ex) {
                Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }
}
