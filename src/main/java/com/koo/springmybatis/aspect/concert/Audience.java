package com.koo.springmybatis.aspect.concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by gu on 2017/11/11.
 */
@Aspect
public class Audience {

    @Before("execution(* com.koo.springmybatis.aspect.concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("silencing cell phones");
    }

    @Before("execution(* com.koo.springmybatis.aspect.concert.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("taking seats");
    }

    @AfterReturning("execution(* com.koo.springmybatis.aspect.concert.Performance.perform(..))")
    public void applause() {
        System.out.println("clap clap clap!!!");
    }

    @AfterThrowing("execution(* com.koo.springmybatis.aspect.concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("demanding a refund");
    }
}
