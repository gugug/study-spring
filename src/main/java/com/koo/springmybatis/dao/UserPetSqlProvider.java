package com.koo.springmybatis.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by gucailiang on 2017/8/22.
 */
public class UserPetSqlProvider {
    public String selectByUserIdAndName(@Param("name") String name, @Param("UserId") int userId) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from UserPet where ");
        sb.append("userId=#{userId}");
        sb.append(" and ");
        sb.append("name=#{name}");
        return sb.toString();
    }
}
