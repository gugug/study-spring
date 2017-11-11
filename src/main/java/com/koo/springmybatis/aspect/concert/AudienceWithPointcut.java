package com.koo.springmybatis.aspect.concert;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by gu on 2017/11/11.
 */
@Aspect
public class AudienceWithPointcut {

    @Pointcut("execution(* com.koo.springmybatis.aspect.concert.Performance.perform(..))")
    public void performance() {

        /**
         * 这个方法实际上是空的，只是一个标识，供@Pointcut注解依附
         */
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("clap clap clap!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("demanding a refund");
    }
}
