# spring 4 纯注解开发整合mybatis

## Aspect切面的使用

## hessian的使用
HessianSeriviceExporter是一个SpringMVC控制器，它可以接收Hessian请求，并将这些请求翻译成对POJO的调用来，从而将POJO导出为一个Hessian服务
请求过程为：  
请求request --> DispatcherServlet ---> HessianSeriviceExporter ---> XXServiceImpl
客户端调用过程：
客户端方法请求---> hessian代理（hessian工程的bean）-- http -> 网络传输---> 服务
