package com.tutorialspoint.jdbcTemplateTest;

import com.koo.springmybatis.service.UserPet.UserPet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gu on 2017/11/7.
 */
public class UserPetJdbcTemplate {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public UserPet getUserPetById(int id){
        return jdbcTemplate.queryForObject("select * from UserPet where userId=?", new RowMapper<UserPet>() {
            @Override
            public UserPet mapRow(ResultSet resultSet, int i) throws SQLException {
                UserPet userPet = new UserPet();
                userPet.setName(resultSet.getString("name"));
                return userPet;
            }
        },id);
    }

}


