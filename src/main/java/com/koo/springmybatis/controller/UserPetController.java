package com.koo.springmybatis.controller;

import com.koo.springmybatis.service.UserPet.UserPetService;
import com.koo.springmybatis.service.UserPet.UserPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gucailiang on 2017/8/22.
 */

@RestController
@RequestMapping("userPet")
public class UserPetController {
    @Autowired
    UserPetService userPetService;

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping(value="testSelect/{id}")
    public Object testSelect(@PathVariable("id") int id ) {
        UserPet select = userPetService.select(id);
        System.out.println(select.toString());
        return select.getName().toString();
    }



}