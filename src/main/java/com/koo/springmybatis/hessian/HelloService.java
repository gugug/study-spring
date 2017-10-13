package com.koo.springmybatis.hessian;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

    @Override
    public String getHelloName(String name) {
        return name;
    }
}
