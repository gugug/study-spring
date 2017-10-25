package com.koo.springmybatis.utils;

import com.koo.springmybatis.service.UserPet.UserPet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用xstream转化xml
 * Created by gucailiang on 2017/10/25.
 */
public class XmlUtils {

    private static Logger logger = LoggerFactory.getLogger(XmlUtils.class);

    public static XStream xStream = new XStream();

    public static String userPetToXml(UserPet userPet) {
        xStream.alias("xml", userPet.getClass());
        return xStream.toXML(userPet);
    }

    /**
     * <root>
     * <entry>
     * <string>k1</string>
     * <string>v1</string>
     * </entry>
     * <entry>
     * <string>k2</string>
     * <string>v2</string>
     * </entry>
     * </root>
     *
     * @param map
     * @return
     */
    public static String mapToXml(Map<String, String> map) {
        xStream.alias("root", Map.class);
        return xStream.toXML(map);
    }

    /**
     * <root>
     * <k1>v1</k1>
     * <k2>v2</k2>
     * </root>
     *
     * @param map
     * @return
     */
    public static String mapToXmlWithoutEntry(Map<String, String> map) {
        xStream.registerConverter(new MapEntryConverter());
        xStream.alias("root", java.util.Map.class);
        return xStream.toXML(map);
    }

    public static Map xmlToMap(String xml) {
        return (Map<String, String>) xStream.fromXML(xml);
    }

    public static class MapEntryConverter implements Converter {
        public boolean canConvert(Class clazz) {
            return AbstractMap.class.isAssignableFrom(clazz);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            AbstractMap map = (AbstractMap) value;
            for (Object obj : map.entrySet()) {
                Map.Entry entry = (Map.Entry) obj;
                writer.startNode(entry.getKey().toString());
                Object val = entry.getValue();
                if (null != val) {
                    writer.setValue(val.toString());
                }
                writer.endNode();
            }

        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map<String, String> map = new HashMap<>();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                String key = reader.getNodeName(); // nodeName aka element's name
                String value = reader.getValue();
                map.put(key, value);
                reader.moveUp();
            }
            return map;
        }

    }

    /**
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>1348831860</CreateTime>
     * <MsgType><![CDATA[text]]></MsgType>
     * <Content><![CDATA[this is a test]]></Content>
     * <MsgId>1234567890123456</MsgId>
     * </xml>
     *
     * @param request
     * @return
     */
    public static Map<String, String> parseHttpRequestXml(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();

        try {
            // 从request中取得输入流
            InputStream inputStream = request.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 根元素
            Element root = document.getRootElement();
            // 根元素下的所有子节点
            List<Element> elementList = root.elements();
            for (Element e : elementList)
                map.put(e.getName(), e.getText());
            inputStream.close();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return map;
    }

    public static void main(String[] args) {
        UserPet userPet = new UserPet();
        userPet.setName("petpet");
        userPet.setUserId(123);
        userPet.setPetId(234);
        String userPetToXml = XmlUtils.userPetToXml(userPet);
        System.out.println(userPetToXml);

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("k1", "v1");
        stringStringHashMap.put("k2", "v2");
        String mapToXml = XmlUtils.mapToXml(stringStringHashMap);
        System.out.println(mapToXml);

        String mapToXmlWithoutEntry = XmlUtils.mapToXmlWithoutEntry(stringStringHashMap);
        System.out.println(mapToXmlWithoutEntry);

        Map map = xmlToMap(mapToXmlWithoutEntry);
        assert map.get("k1").equals("v1");

    }

}
