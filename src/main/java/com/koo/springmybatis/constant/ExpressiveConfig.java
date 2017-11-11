package com.koo.springmybatis.constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by gu on 2017/11/11.
 */
@Configuration
@PropertySource("classpath:my-config.properties")
public class ExpressiveConfig {
    @Autowired
    Environment env;

    public void testProperties(){
        String title = env.getProperty("app.title");
        String artist = env.getProperty("app.artist");
        System.out.println(title);
        System.out.println(artist);
    }
}
