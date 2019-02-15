package com.qgx.download.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *@Author: Goxcheer
 *@Date:17:45 2019/1/10
 *@Email:604721660@qq.com
 *@decription:资源实体
 */
@Data
public class Article implements Serializable {

    private Integer id; //编号

    private String name; //资源名称

    private Date publishDate; //发布日期

    private String publishDateStr; //发布日期字符串

    private User user; //所属用户

    private ArticleType articleType; //所属资源类型

    private Integer points; //下载积分

    private String content; //资源描述

    private String downloadUrl; //百度云下载地址

    private String downloadCode; //下载码

    private String isHot = "0"; //是否是热门资源 0，1

    private Integer state; //审核状态

    private String reason; //审核未通过原因

    private Date checkDate; //审核日期

    private String isUseful ; //资源是否有效 0，1

    private Integer views; //浏览次数

}
