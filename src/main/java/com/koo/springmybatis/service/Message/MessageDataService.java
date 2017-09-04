package com.koo.springmybatis.service.Message;

import com.koo.springmybatis.constant.GlobalConfig;
import com.koo.springmybatis.utils.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by gucailiang on 2017/8/25.
 */
@Service
public class MessageDataService {

    @Resource
    FileHelper fileHelper;

    public void saveInfo(int temperature, int humidity) {
        fileHelper.doFileWrite(GlobalConfig.RECORD_DIR, temperature + " - " + humidity);
    }

}
