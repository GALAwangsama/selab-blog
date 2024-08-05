package com.selabBlog.server.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.selabBlog.pojo.VO.SelectVO;
import com.selabBlog.pojo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ArticleMapper extends BaseMapper<Article> {
    IPage<Map> showLoad(IPage<Article> page);
    IPage<Map> showSelectByUserId(IPage<Article> page,@Param("uid") long uid);
    SelectVO showArticleDetails(Long aid);

}
