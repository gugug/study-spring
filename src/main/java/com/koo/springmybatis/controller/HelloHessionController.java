package com.koo.springmybatis.controller;

import com.koo.springmybatis.service.hello.HelloHessianService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloHessionController {

    @Resource
    HelloHessianService helloHessianService;

    @RequestMapping("testHessian")
    public String testHessian(){
        return helloHessianService.getStringName("hello hessian");
    }
}
