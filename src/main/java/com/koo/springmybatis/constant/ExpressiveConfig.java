package com.koo.springmybatis.constant;

import com.koo.springmybatis.service.UserPet.UserPet;
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

    public String getTitle() {
        /**
         * 这个属性没有定义的时候返回null
         */
        return env.getProperty("app.title");
    }

    public int getConnectionCount() {
        /**
         * 转换指定的数据类型的值，没有定义的时候使用默认值
         */
        return env.getProperty("db.connection.count", Integer.class, 30);
    }

    public String getArtist() {
        /**
         * 属性必须定义，否则报错IllegalStateException
         */
        return env.getRequiredProperty("app.artist");
    }

    public Class<UserPet> getUserPetClass() {
        /**
         * 转化为类
         */
        return env.getPropertyAsClass("user.class", UserPet.class);
    }

}
