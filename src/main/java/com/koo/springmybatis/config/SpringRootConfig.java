package com.koo.springmybatis.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 组件扫描开启ComponentScan，会扫描@component注解的组件类
 * 如果没有其他配置的话，会扫描和配置类相同的包以及这个包下的所有子包，查找带有@component注解的类，然后会在spring中自动创建一个bean
 * Created by gucailiang on 2017/8/22.
 */
@Configuration
@ComponentScan("com.koo.springmybatis")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@Import(DaoConfig.class)
public class SpringRootConfig {
    @Bean
    public PropertyPlaceholderConfigurer getTestPpc() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("jdbc2.properties"));
        return ppc;
    }
}
