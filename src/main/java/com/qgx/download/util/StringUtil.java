package com.qgx.download.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 *@Author: Goxcheer
 *@Date:16:59 2019/1/11
 *@Email:604721660@qq.com
 *@decription: 字符串工具类
 */
public class StringUtil {

    public final static String SALT = "goxcheer"; //加密的盐值

    /**
     * md5加密
     * @param str
     * @return
     */
    public static String md5Encrypt(String str) {
        return new Md5Hash(str,SALT).toString();
    }
}
