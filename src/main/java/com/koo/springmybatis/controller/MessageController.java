package com.koo.springmybatis.controller;

import com.koo.springmybatis.service.Message.MessageData;
import com.koo.springmybatis.service.Message.MessageDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gucailiang on 2017/9/4.
 */
@RestController
public class MessageController {
    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageDataService messageDataService;
    private int currTemperature = 0;
    private int currHumidity = 0;

    @RequestMapping("fetcher/{temperature}/{humidity}")
    public Object fetcher(@PathVariable(value = "temperature") Integer temperature, @PathVariable(value = "humidity") Integer humidity, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        LOG.info("fetcher temperature: {}, humidity: {}", temperature, humidity);
        Map<String, String> result = new HashMap<>();
        try {
            if (temperature != null && humidity != null) {
                currTemperature = temperature;
                currHumidity = humidity;
                if (messageDataService.saveInfo(currTemperature, currHumidity)) {
                    result.put("result", "success");
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            result.put("result", "fail");
        }
        return result;
    }

    @RequestMapping("sender")
    public MessageData sender() {
        LOG.info("sender temperature: {}, humidity: {}", currTemperature, currHumidity);
        MessageData sender = null;
        Map<String, String> result = new HashMap<>();
        try {
            sender = messageDataService.sender(currTemperature, currHumidity);
            result.put("result", "success");
        } catch (Exception e) {
            LOG.error(e.getMessage());
            result.put("result", "fail");
        }
        return sender;
    }

}
