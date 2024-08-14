package com.selabBlog.server.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.selabBlog.pojo.VO.SelectArticleVO;
import com.selabBlog.pojo.VO.SelectVO;
import com.selabBlog.pojo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Map> showLoad();
    Map showSelectByUserId(@Param("uid") long uid);
    SelectVO showArticleDetails(Long aid);

    SelectArticleVO selectByArticleId(Long id);
}
