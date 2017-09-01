package com.tutorialspoint.configurationtest;

import org.springframework.stereotype.Service;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Service
public class TextEditor {
    private SpellChecker spellChecker;
    public TextEditor(SpellChecker spellChecker){
        System.out.println("Inside TextEditor constructor." );
        this.spellChecker = spellChecker;
    }
    public void spellCheck(){
        spellChecker.checkSpelling();
    }
}
