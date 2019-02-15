package com.qgx.download.entity;

import lombok.Data;

import java.util.Date;

/**
 *@Author: Goxcheer
 *@Date:18:08 2019/1/10
 *@Email:604721660@qq.com
 *@decription: 用户下载实体
 */
@Data
public class UserDownload {

    private Integer id; //编号

    private User user; //下载用户

    private Article article; //下载文章

    private Date downloadDate; // 下载日期

}
