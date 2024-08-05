package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.SelectVO;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.server.Mapper.ArticleMapper;
import com.selabBlog.server.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Result load() {
        IPage<Article> page = new Page<>(1, 10);
        //分页查询
        articleMapper.showLoad(page);

        //返回查询结果
        List<Article> records = page.getRecords();

        return Result.success(records);
    }

    @Override
    public Result articleDetails(Long aid) {
        SelectVO data =  articleMapper.showArticleDetails(aid);

        return Result.success(data);
    }

    @Override
    public Result selectByUserId(Long uid) {
        IPage<Article> page = new Page<>(1, 10);
        //分页查询
        articleMapper.showSelectByUserId(page, uid);

        //返回查询结果
        List<Article> records = page.getRecords();
        return Result.success(records);
    }
}
