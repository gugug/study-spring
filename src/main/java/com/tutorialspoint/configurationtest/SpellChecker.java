package com.tutorialspoint.configurationtest;

import org.springframework.stereotype.Service;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Service
public class SpellChecker {

    public SpellChecker(){
        System.out.println("Inside SpellChecker constructor." );
    }
    public void checkSpelling(){
        System.out.println("Inside checkSpelling." );
    }
}
