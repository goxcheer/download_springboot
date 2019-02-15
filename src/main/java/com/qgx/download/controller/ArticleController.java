package com.qgx.download.controller;

import com.qgx.download.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author: Goxcheer
 *@Date:11:05 2019/1/18
 *@Email:604721660@qq.com
 *@decription: 资源Controller层
 */
@RestController
@Slf4j
public class ArticleController {

    @Resource
    private ArticleService articleService;



    @PostMapping(value = "/publishArticle",produces = "application/json; charset=utf-8")
    public Map<String, Object> publishArticle(@RequestBody Map<String, Object>paramsMap){
        log.info(paramsMap.toString());
        Map<String,Object>map = new HashMap<>();
        if (articleService.saveArticle(paramsMap)){
            map.put("result","true");
        } else {
            map.put("result","false");
            map.put("errorMsg","添加资源失败！");
        }
        return map;
    }
}
