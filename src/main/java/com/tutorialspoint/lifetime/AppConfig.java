package com.tutorialspoint.lifetime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gucailiang on 2017/8/16.
 */
@Configuration
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public Foo foo() {
        return new Foo();
    }
}
