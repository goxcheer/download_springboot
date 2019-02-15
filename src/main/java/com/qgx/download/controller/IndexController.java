package com.qgx.download.controller;

import com.qgx.download.entity.Article;
import com.qgx.download.entity.ArticleType;
import com.qgx.download.service.ArticleService;
import com.qgx.download.service.ArticleTypeService;
import com.qgx.download.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:15:25 2019/1/16
 *@Email:604721660@qq.com
 *@decription: 首页Controller
 */
@RestController
@Slf4j
public class IndexController {

    @Resource
    private ArticleTypeService articleTypeService;
    @Resource
    private ArticleService articleService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping(value = "/countArticle",produces = "application/json; charset=utf-8")
    public Map<String,Object>countArticle(@RequestBody(required = false) Map<String, Object>paramsMap){
        Map<String,Object>map = new HashMap<>();
        paramsMap.put("state",2); //审核通过的
        paramsMap.put("is_useful",1); //未失效
        Integer total = articleService.countArticle(paramsMap);
        if (total != null) {
            map.put("result","true");
            map.put("total",total);
        } else {
            map.put("result","false");
            map.put("errorMsg","查询资源总数失败");
        }
        return map;
    }

    @PostMapping(value = "/listArticleType",produces = "application/json; charset=utf-8")
    public Map<String,Object> listArticleType(){
        Map<String,Object>map = new HashMap<>();
        List<ArticleType> articleTypeList = null;
        if (redisUtil.hasKey("articleTypeList")){
            articleTypeList = (List<ArticleType>) redisUtil.get("articleTypeList");
        } else {
            articleTypeList = articleTypeService.listArticleType();
            redisUtil.set("articleTypeList",articleTypeList);
        }
        if (articleTypeList != null) {
            map.put("result","true");
            map.put("articleTypeList",articleTypeList);
        } else {
            map.put("result","false");
            map.put("errorMsg","获取资源类型出错！");
        }
        return map;
    }



    @PostMapping(value = "/listArticle",produces = "application/json; charset=utf-8")
    public Map<String, Object>listArticle(@RequestBody  Map<String, Object>paramsMap) {
        log.info(paramsMap.toString());
        paramsMap.put("state",2); //审核通过的
        paramsMap.put("is_useful",1); //未失效
        List<Article>articleList =  null;
        Map<String, Object>map = new HashMap<>();
        articleList = articleService.listArticle(paramsMap);
        if (articleList != null) {
            map.put("result","true");
            map.put("articleList",articleList);
        } else {
            map.put("result","false");
            map.put("errorMsg","获取资源出错！");
        }
        return map;
    }
}
