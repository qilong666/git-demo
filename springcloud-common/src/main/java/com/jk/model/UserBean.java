package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/3 18:06
 * @Created by ${jmh}
 */
public class UserBean implements Serializable {


                 private  Integer  userId;

                 private  String    uName;

                 private  String    password;

                @DateTimeFormat(pattern = "yyyy-MM-dd")
                @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
                 private  Date     regDate;

                 private  Integer  userAge;

                 private  String    userImg;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }




}
