package com.koo.springmybatis.controller;

import com.koo.springmybatis.config.SpringRootConfig;
import com.koo.springmybatis.hessian.IHelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * RunWith 自动闯将spring上下文
 * ContextConfiguration 在class中加载配置
 * Created by gu on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringRootConfig.class)
public class HelloHessionControllerTest {

    @Autowired
    private IHelloService helloService;

    @Test
    public void helloServiceShouldNotBeNull(){
        assertNotNull(helloService);
    }

}