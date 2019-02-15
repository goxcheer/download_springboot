package com.qgx.download.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *@Author: Goxcheer
 *@Date:17:52 2019/1/10
 *@Email:604721660@qq.com
 *@decription: 用户实体
 */

@Data
public class User implements Serializable {

    private Integer id; //编号

    private String account; //账号

    private String password; //密码

    private String nickName; //昵称

    private String email; //邮箱

    private Integer points; //积分

    private String isVip = "0" ; //是否是vip.0代表否，1代表是

    private String isOff = "0"; //是否被封禁，0代表否，1代表是

    private String roleName ; //分两种，会员，管理员

    private Date registerDate; //注册日期

    private Integer messageCount;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
