package com.koo.springmybatis.service.Message;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by gucailiang on 2017/8/25.
 */

@Mapper
public interface MessageDataMapper {

    MessageData fetcher();

    MessageData sender();

}
