package com.koo.springmybatis.utils;

import com.koo.springmybatis.service.UserPet.UserPet;
import com.thoughtworks.xstream.XStream;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用xstream转化xml
 * Created by gucailiang on 2017/10/25.
 */
public class XmlUtils {

    public static XStream xStream = new XStream();

    public static String userPetToXml(UserPet userPet) {
        xStream.alias("xml", userPet.getClass());
        return xStream.toXML(userPet);
    }

    public static String mapToXml(Map<String,String> map){
        xStream.alias("root", Map.class);
        return xStream.toXML(map);
    }

    public static void main(String[] args) {
        UserPet userPet = new UserPet();
        userPet.setName("petpet");
        userPet.setUserId(123);
        userPet.setPetId(234);
        String userPetToXml = XmlUtils.userPetToXml(userPet);
        System.out.println(userPetToXml);

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("k1","v1");
        stringStringHashMap.put("k2","v2");
        String mapToXml = XmlUtils.mapToXml(stringStringHashMap);
        System.out.println(mapToXml);
    }
}
