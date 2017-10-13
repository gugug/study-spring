package com.koo.springmybatis.service.hello;

import com.koo.springmybatis.hessian.HessianConsumer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloHessianService {

    @Resource
    HessianConsumer hessianConsumer;

    public String getStringName(String name){
        return hessianConsumer.getIHelloService().getHelloName(name);
    }
}
