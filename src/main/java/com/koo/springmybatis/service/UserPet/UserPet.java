package com.koo.springmybatis.service.UserPet;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by gucailiang on 2017/8/22.
 */
public class UserPet {
    private int userId;
    private int petId;
    private int raceId;
    @XStreamAlias("pet_name")
    private String name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
