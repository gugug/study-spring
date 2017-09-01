package com.tutorialspoint.configurationtest;

/**
 * Created by gucailiang on 2017/8/16.
 */
import org.springframework.context.annotation.*;

public class MainApp {
    public static void main(String[] args) {
//        ApplicationContext ctx =
//                new AnnotationConfigApplicationContext(HelloWorldConfig.class);
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
//        helloWorld.setMessage("Hello World!");
//        helloWorld.getMessage();

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(TextEditorConfig.class);
        ctx.refresh();
        TextEditor textEditor = ctx.getBean(TextEditor.class);
        textEditor.spellCheck();

    }
}
