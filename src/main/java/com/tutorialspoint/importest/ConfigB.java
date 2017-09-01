package com.tutorialspoint.importest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Configuration
@Import(ConfigA.class)
public class ConfigB {
    @Bean
    public B a() {
        return new B();
    }
}
