package com.koo.springmybatis.service;

import org.springframework.stereotype.Service;

/**
 * Created by gucailiang on 2017/9/1.
 */

@Service
public class UserService {

    public String getNameById(Long id) {
        System.out.println("我是getNameById()方法");
        return "csy";
    }

    public void save(String name) {
        throw new RuntimeException("故意抛出了异常,仅供测试");
    }

    public void update(String name, Long id) {
        System.out.println("我是update()方法");
    }

}