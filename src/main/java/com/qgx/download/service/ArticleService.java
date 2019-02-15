package com.qgx.download.service;

import com.qgx.download.entity.Article;

import java.util.List;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:11:07 2019/1/18
 *@Email:604721660@qq.com
 *@decription: 资源Service接口
 */
public interface ArticleService {
    /**
     * 发布资源
     * @param paramsMap
     * @return
     */
    boolean saveArticle(Map<String,Object> paramsMap);

    /**
     * 条件获取资源集合
     * @param paramsMap
     * @return
     */
    List<Article> listArticle(Map<String,Object> paramsMap);

    /**
     * 查询资源总数
     * @return
     */
    Integer countArticle(Map<String,Object> paramsMap);
}
