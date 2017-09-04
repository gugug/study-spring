package com.koo.springmybatis.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by gucailiang on 2017/8/22.
 */
@Configuration
@ComponentScan("com.koo.springmybatis")
@EnableAspectJAutoProxy(proxyTargetClass=true)
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
