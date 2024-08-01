package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.server.Mapper.ArticleMapper;
import com.selabBlog.server.Service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
