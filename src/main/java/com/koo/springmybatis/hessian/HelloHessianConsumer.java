package com.koo.springmybatis.hessian;

import com.caucho.hessian.client.HessianProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.net.MalformedURLException;

@Configuration
public class HelloHessianConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(HelloHessianConsumer.class);

    private IHelloService helloService;

    private String hessianUrl = "http://127.0.0.1:8080/hessianHelloService";

    public HelloHessianConsumer() {
        this.helloService = createService(IHelloService.class, hessianUrl);
    }

    public IHelloService getIHelloService() {
        return helloService;
    }

    public <T> T createService(Class<? extends T> classSrc, String url) {
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("hessian服务链接出错:" + url);
        }
        return createHessianService(classSrc, url);
    }


    public static <T> T createHessianService(Class<T> api, String serverUrl) {
        T obj = null;
        if (serverUrl != null) {
            try {
                HessianProxyFactory hFactory = buildFactory(5000,5000);
                obj = api.cast(hFactory.create(api, serverUrl));
            } catch (MalformedURLException e) {
                LOG.error("create hessianService failed:", e);
            }
        }
        return obj;
    }

    //设置各种超时时间，单位是毫秒
    private static HessianProxyFactory buildFactory(long connectTimeout, long readTimeout) {
        HessianProxyFactory factory = new HessianProxyFactory();
        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }


}
