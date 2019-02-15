package com.qgx.download.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *@Author: Goxcheer
 *@Date:17:59 2019/1/10
 *@Email:604721660@qq.com
 *@decription: 资源类型
 */
@Data
public class ArticleType implements Serializable {

    private Integer id; //编号

    private String name; //资源类型名称

    private String remark; //资源描述

    private Integer priority; //优先级
}
