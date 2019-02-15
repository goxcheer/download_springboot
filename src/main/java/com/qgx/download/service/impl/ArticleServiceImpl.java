package com.qgx.download.service.impl;

import com.qgx.download.dao.ArticleDao;
import com.qgx.download.dao.UserDao;
import com.qgx.download.entity.Article;
import com.qgx.download.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;
    @Resource
    private UserDao userDao;

    @Override
    public boolean saveArticle(Map<String, Object> paramsMap) {
        Map<String, Object>paramsMap2 = new HashMap<>();
        paramsMap2.put("points",20);
        paramsMap2.put("userId",paramsMap.get("userId"));
        return articleDao.saveArticle(paramsMap) > 0 && userDao.updateUser(paramsMap2) > 0;
    }

    @Override
    public List<Article> listArticle(Map<String, Object> paramsMap) {
        return articleDao.listArticle(paramsMap);
    }

    @Override
    public Integer countArticle(Map<String,Object> paramsMap) {
        return articleDao.countArticle(paramsMap);
    }
}
