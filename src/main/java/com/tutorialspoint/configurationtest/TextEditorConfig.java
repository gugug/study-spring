package com.tutorialspoint.configurationtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Configuration
public class TextEditorConfig {
    @Bean
    public TextEditor textEditor(){
        return new TextEditor(spellChecker());
    }
    @Bean
    public SpellChecker spellChecker(){
        return new SpellChecker( );
    }
}
