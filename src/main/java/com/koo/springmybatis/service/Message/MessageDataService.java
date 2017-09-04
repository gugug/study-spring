package com.koo.springmybatis.service.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 *
 * Created by gucailiang on 2017/8/25.
 */
@Service
public class MessageDataService {

    @Resource
    MessageDataMapper messageDataMapper;


    public MessageData sender(int temperature, int humidity) {
        return messageDataMapper.sender(temperature, humidity);
    }

    public boolean saveInfo(int temperature, int humidity) {
        return messageDataMapper.saveInfo(temperature,humidity);
    }

}
