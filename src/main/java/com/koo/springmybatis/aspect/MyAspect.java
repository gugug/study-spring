package com.koo.springmybatis.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by gucailiang on 2017/9/1.
 */
@Aspect
public class MyAspect {

    //切入点要拦截的类"execution (* com..*.*(..))"
    @Pointcut()
    public void anyMethod() {
        //声明一个切入点,切入点的名称其实是一个方法
    }

    //前置通知（不需要获取输入参数)
    @Before("anyMethod()")//第一个参数为切入点的名称
    public void doAccessCheck() {

        System.out.println("前置通知");
    }

    //后置通知(不需要获取返回值)
    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知:");
    }

    //例外通知(不需要异常信息)
    @AfterThrowing("anyMethod()")
    public void doAfterThrowing() {
        System.out.println("例外通知");
    }

    //最终通知
    @After("anyMethod()")
    public void doAfter() {
        System.out.println("最终通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知进入方法");
        Object object = pjp.proceed();
        System.out.println("环绕通知退出方法");
        return object;
    }

}
