package com.qgx.download.service.impl;

import com.qgx.download.dao.ArticleTypeDao;
import com.qgx.download.entity.ArticleType;
import com.qgx.download.service.ArticleTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Author: Goxcheer
 *@Date:16:52 2019/1/16
 *@Email:604721660@qq.com
 *@decription: 资源类型Service实现类
 */
@Service("articleTypeService")
@Transactional
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Resource
    private ArticleTypeDao articleTypeDao;

    @Override
    public List<ArticleType> listArticleType() {
        return articleTypeDao.listArticleType();
    }
}
