package com.tutorialspoint.configurationtest;

import org.springframework.stereotype.Service;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Service
public class HelloWorld {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
