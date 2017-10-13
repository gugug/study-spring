package com.koo.springmybatis.hessian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import javax.annotation.Resource;

@Configuration
public class HessianProvider {
    @Resource
    HelloService helloService;

    @Bean(name = "/hessianHelloService")
    public HessianServiceExporter hessianTestWxQrService() {
        System.out.println("hessianHelloService......");
        HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
        hessianServiceExporter.setService(helloService);
        hessianServiceExporter.setServiceInterface(IHelloService.class);
        return hessianServiceExporter;
    }
}
