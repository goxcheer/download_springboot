package com.qgx.download.controller;

import com.qgx.download.entity.User;
import com.qgx.download.service.UserService;
import com.qgx.download.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:15:23 2019/1/11
 *@Email:604721660@qq.com
 *@decription: 用户Controller层
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/register",produces ="application/json; charset=utf-8")
    public Map<String, Object> register(@RequestBody User user){
        Map<String,Object>map = new HashMap<>();
        log.info("user:"+user);
        if (userService.getUserByAccount(user.getAccount()) != null) {
            map.put("result","false");
            map.put("errorMsg","此账号已存在！");
        } else if (userService.emailIsExist(user.getEmail())) {
            map.put("result","false");
            map.put("errorMsg","此邮箱已存在！");
        } else {
            user.setRegisterDate(new Date());
            user.setPassword(StringUtil.md5Encrypt(user.getPassword()));
            if (userService.saveUser(user)) {
                map.put("result","true");
            }
        }
        return map;
    }

    @PostMapping(value = "/login",produces ="application/json; charset=utf-8" )
    public Map<String, Object>login(@RequestBody Map<String,Object>paramsMap) {
        log.info(paramsMap.toString());
        Map<String,Object>map = new HashMap<>();
        User user = new User(paramsMap.get("account").toString(), paramsMap.get("password").toString());
        user.setPassword(StringUtil.md5Encrypt(user.getPassword()));
        User currentUser = userService.getUserByAccount(user.getAccount());
        if (currentUser !=null & currentUser.getPassword().equals(user.getPassword())) {
            map.put("result", "true");
            map.put("currentUser",currentUser);
        } else {
            map.put("result","false");
            map.put("errorMsg","用户名或密码错误！");
        }
        return map;
    }

    @PostMapping(value = "/updatePsw",produces = "application/json; charset=utf-8")
    public Map<String, Object>updatePsw(@RequestBody Map<String, Object>paramMap) {
        log.info(paramMap.toString());
        Map<String,Object>resultMap = new HashMap<>();
        User currentUser = userService.getUserByAccount(paramMap.get("account").toString());
        if (currentUser == null ) {
            resultMap.put("result", "false");
            resultMap.put("errorMsg","登陆信息出错了，请重新登陆，骚猪！");
        } else if (! currentUser.getPassword().equals(StringUtil.md5Encrypt(paramMap.get("newPassword").toString()))) {
            resultMap.put("result", "false");
            resultMap.put("errorMsg","您输入的原密码正确吗？老铁？");
        } else {
            Map<String,Object>updateMap = new HashMap<>();
            updateMap.put("account",paramMap.get("account"));
            updateMap.put("newPassword",paramMap.get("newPassword"));
            User newUser = userService.updateUser(updateMap);
            if (newUser != null) {
                resultMap.put("result", "true");
                resultMap.put("currentUser",newUser);
            } else {
                resultMap.put("result", "false");
                resultMap.put("errorMsg","更新失败，what the fuck！");
            }
        }
        return resultMap;
    }
    public static void main(String[] args) {
    }
}
