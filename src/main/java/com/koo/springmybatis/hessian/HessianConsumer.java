package com.koo.springmybatis.hessian;

import com.caucho.hessian.client.HessianProxyFactory;
import com.koo.springmybatis.constant.GlobalConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;

@Configuration
public class HessianConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(HessianConsumer.class);

    private IHelloService helloService;

    public HessianConsumer() {
        this.helloService = createService(IHelloService.class, GlobalConfig.HESSIAN_URL_HELLOSERVICE);
    }

    @PostConstruct
    void init(){
        this.helloService = createService(IHelloService.class, GlobalConfig.HESSIAN_URL_HELLOSERVICE);
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
