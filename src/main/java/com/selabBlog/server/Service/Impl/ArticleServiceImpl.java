package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.SelectArticleVO;
import com.selabBlog.pojo.VO.SelectVO;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.server.Mapper.ArticleMapper;
import com.selabBlog.server.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Result load() {
        List<Map> map = articleMapper.showLoad();


        return Result.success(map);

    }

    @Override
    public Result articleDetails(Long aid) {

        SelectVO data =  articleMapper.showArticleDetails(aid);

        return Result.success(data);
    }

    @Override
    public Result selectByUserId(Long uid) {

        return Result.success(articleMapper.showSelectByUserId(uid));

    }

    @Override
    public Result selectByArticleId(Long id) {
        SelectArticleVO selectArticleVO = articleMapper.selectByArticleId(id);
        if (selectArticleVO == null){
            return Result.error("选择文章失败");
        }else {
            selectArticleVO.setId(id);
            return Result.success(selectArticleVO);
        }
    }

}
