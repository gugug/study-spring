package com.koo.springmybatis.constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfig {
    final static String ROOT_DIR = "D:/IdeaProjects/study-spring/";
    public static String RECORD_DIR = "Record/record.txt";

    public GlobalConfig() {
        RECORD_DIR = getValue("RECORD.PATH");
    }

    private static Properties prop = new Properties();

    static {
        ClassLoader loader = GlobalConfig.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("my-config.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}
