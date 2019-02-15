package com.qgx.download.service;

import com.qgx.download.entity.User;

import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:15:50 2019/1/11
 *@Email:604721660@qq.com
 *@decription: 用户Service接口
 */
public interface UserService {


    /**
     * 判断邮箱是否存在
     * @param email
     * @return
     */
    boolean emailIsExist(String email);

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean saveUser(User user);

    /**
     * 根据账号获取用户
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    User updateUser(Map<String,Object> updateMap);
}
