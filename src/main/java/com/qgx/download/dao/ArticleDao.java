package com.qgx.download.dao;

import com.qgx.download.entity.Article;
import com.sun.crypto.provider.DESCipher;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:11:09 2019/1/18
 *@Email:604721660@qq.com
 *@decription: 资源Dao接口
 */
@Mapper
public interface ArticleDao {

    @Insert("insert into t_article (name,download_url,downloadCode,points,article_type_id,user_id,is_hot,publish_date,state,content,is_useful,views) values" +
            "(#{article.name},#{article.downloadUrl},#{article.downloadCode},#{article.points},#{article.articleType},#{userId},0,now(),0,#{article.content},1,0)")
    Integer saveArticle(Map<String,Object> paramsMap);

    @SelectProvider(type = ArticleDaoProvider.class, method = "listArticle")
    @Results(value = {@Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "name", property = "name", javaType = String.class),
            @Result(column = "points", property = "points", javaType = Integer.class),
            @Result(column = "views", property = "views", javaType = Integer.class),
            @Result(column = "publish_date_str", property = "publishDateStr", javaType = String.class),
            @Result(column = "user_id", property = "user", one=@One(select = "com.qgx.download.dao.UserDao.getUserById",fetchType = FetchType.EAGER))
            })
    List<Article> listArticle(Map<String,Object> paramsMap);

    @SelectProvider(type = ArticleDaoProvider.class, method = "countArticle")
    Integer countArticle(Map<String,Object> paramsMap);

    class ArticleDaoProvider{
        public String listArticle(Map<String,Object> paramsMap){
            return new SQL(){{
                SELECT("*");
                FROM("t_article");
                if (paramsMap.get("state") != null) {
                    WHERE("state = #{state}");
                }
                if (paramsMap.get("is_useful") != null) {
                    WHERE("is_useful = #{is_useful}");
                }
                if (paramsMap.get("articleTypeId") != null && ! "0".equals(paramsMap.get("articleTypeId").toString())) {
                    WHERE("article_type_id = #{articleTypeId}");
                }
                ORDER_BY("publish_date desc limit #{start},#{pageSize}");
            }}.toString();
        }

        public String countArticle(Map<String,Object> paramsMap){
            return new SQL(){{
                SELECT("count(*)");
                FROM("t_article");
                if (paramsMap.get("state") != null) {
                    WHERE("state = #{state}");
                }
                if (paramsMap.get("is_useful") != null) {
                    WHERE("is_useful = #{is_useful}");
                }
                if (paramsMap.get("articleTypeId") != null && ! "0".equals(paramsMap.get("articleTypeId").toString())) {
                    WHERE("article_type_id = #{articleTypeId}");
                }
            }}.toString();
        }
    }
}
