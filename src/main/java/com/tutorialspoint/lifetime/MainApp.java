package com.tutorialspoint.lifetime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by gucailiang on 2017/8/16.
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Foo foo = ctx.getBean(Foo.class);

    }

}
