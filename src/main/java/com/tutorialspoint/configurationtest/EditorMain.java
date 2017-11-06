package com.tutorialspoint.configurationtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gu on 2017/11/6.
 */
public class EditorMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/xml/TextEditorConfig.xml");
        TextEditor textEditor = context.getBean(TextEditor.class);
        textEditor.spellCheck();
        context.close();
    }
}
