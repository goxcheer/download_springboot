package com.qgx.download.service;

import com.qgx.download.entity.ArticleType;

import java.util.List;

/**
 *@Author: Goxcheer
 *@Date:16:51 2019/1/16
 *@Email:604721660@qq.com
 *@decription: 资源类型service接口
 */
public interface ArticleTypeService {
    /**
     * 查询所有的资源类别
     * @return
     */
    List<ArticleType> listArticleType();
}
