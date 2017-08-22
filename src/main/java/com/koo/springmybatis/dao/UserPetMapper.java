package com.koo.springmybatis.dao;

import com.koo.springmybatis.entity.UserPet;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gucailiang on 2017/8/22.
 */
@Repository
@Mapper
public interface UserPetMapper {
    @Insert(value="insert into UserPet(userId, petId, raceId, name) values (#{userId}, #{petId}, #{raceId}, #{name})")
    void add(UserPet userPet);

    @Delete(value="delete from UserPet where userId=#{userId}")
    void delete(long usreId);

    @Update(value="update UserPet set name=#{name}, where userId=#{userId}")
    void update(UserPet userPet);

    @Select(value="select * from UserPet where userId=#{userId}")
    UserPet select(int userId);

    @SelectProvider(type=UserPetSqlProvider.class, method="selectByUserIdAndName")
    List<UserPet> selectByUserIdAndName(@Param("name") String name, @Param("userId") int userId);
}
