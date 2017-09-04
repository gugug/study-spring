package com.koo.springmybatis.service.UserPet;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by gucailiang on 2017/8/22.
 */
@Service
public class UserPetService {

    @Resource
    private UserPetMapper userPetMapper;

    public UserPet select(int userId){
        return userPetMapper.select(userId);
    }
}
