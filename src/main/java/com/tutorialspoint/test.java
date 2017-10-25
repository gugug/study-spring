package com.tutorialspoint;

import com.koo.springmybatis.service.UserPet.UserPet;
import com.koo.springmybatis.utils.XmlUtils;

import java.io.File;

/**
 * Created by gucailiang on 2017/9/8.
 */
public class test {
    public static void main(String[] args) {
        File f = new File("src\\main\\java\\com\\tutorialspoint\\configurationtest\\");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());

        UserPet userPet = new UserPet();
        userPet.setName("petpet");
        userPet.setUserId(123);
        userPet.setPetId(234);
        String userPetToXml = XmlUtils.userPetToXml(userPet);
        System.out.println(userPetToXml);

    }

}
