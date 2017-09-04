package com.koo.springmybatis.controller;

import com.koo.springmybatis.service.Message.MessageData;
import com.koo.springmybatis.service.Message.MessageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gucailiang on 2017/9/4.
 */
@RestController
public class MessageController {
    @Autowired
    MessageDataService messageDataService;

    @RequestMapping("fetcher")
    public MessageData fetcher() {
        MessageData fetcher = messageDataService.fetcher();
        return fetcher;
    }

    @RequestMapping("sender")
    public MessageData sender() {
        MessageData sender = messageDataService.sender();
        return sender;
    }

}
