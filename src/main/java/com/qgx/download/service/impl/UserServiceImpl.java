package com.qgx.download.service.impl;

import com.qgx.download.dao.UserDao;
import com.qgx.download.entity.User;
import com.qgx.download.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:15:49 2019/1/11
 *@Email:604721660@qq.com
 *@decription: 用户Service实现类
 */
@Service("userService")
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    public boolean emailIsExist(String email) {
        return userDao.getUserByEmail(email) != null ? true : false;
    }

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user) > 0 ? true : false;
    }

    @Override
    public User updateUser(Map<String, Object> updateMap) {
        Integer result = userDao.updateUser(updateMap);
        User newUser = null;
        if (result > 0) {
            newUser = userDao.getUserByAccount(updateMap.get("account").toString());
        }
        return newUser;
    }
}
