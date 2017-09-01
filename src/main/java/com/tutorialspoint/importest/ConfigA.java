package com.tutorialspoint.importest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Configuration
public class ConfigA {

    @Bean
    public A a(){
        return new A();
    }
}
