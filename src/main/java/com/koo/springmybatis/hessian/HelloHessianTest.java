package com.koo.springmybatis.hessian;

public class HelloHessianTest {
    public static void main(String[] args) {
        HelloHessianConsumer helloHessianConsumer = new HelloHessianConsumer();
        IHelloService helloService = helloHessianConsumer.getIHelloService();
        System.out.println(helloService);
        String helloHessian = helloService.getHelloName("hello hessian");
        System.out.println(helloHessian);

    }
}
