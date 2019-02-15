package com.qgx.download.dao;

import com.qgx.download.entity.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Author: Goxcheer
 *@Date:17:13 2019/1/16
 *@Email:604721660@qq.com
 *@decription:资源类别Dao接口
 */
@Mapper
public interface ArticleTypeDao {

    @Select("select * from t_article_type order by priority")
    List<ArticleType> listArticleType();
}
