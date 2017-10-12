package com.koo.springmybatis.constant;

import com.oracle.webservices.internal.api.message.PropertySet.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfig {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalConfig.class);

    @Property("HESSIAN.URL.HELLOSERVICE")
    public static String HESSIAN_URL_HELLOSERVICE = "http://127.0.0.1:8080/hessianHelloService";
    @Property("RECORD.PATH")
    public static String RECORD_DIR = "http://127.0.0.1:8080/hessianHelloService";

    public GlobalConfig() {
    }

    private static Properties prop = new Properties();

    static {
        ClassLoader loader = GlobalConfig.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("my-config.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            System.out.println("my-config.properties 文件找不到");
            LOG.error(e.getMessage(),e);
        }
    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}
