package com.selabBlog;

import cn.hutool.core.bean.BeanUtil;
import com.selabBlog.pojo.DTO.UpdateDTO;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.server.Service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SelabBlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ArticleService articleService;

    @Test
    void saveArticleTest() {
        Article article = new Article();
        article.setImage("image.jpg");
        article.setTitle("test");
        article.setContent("test content");
        article.setUserId(1L);
        articleService.save(article);
    }

    @Test
    void deleteArticleTest() {
        articleService.removeById(1L);
    }

    @Test
    void updateArticleTest() {
        UpdateDTO updateDTO = new UpdateDTO();
        updateDTO.setId(2L);
        updateDTO.setTitle("test4");
        updateDTO.setImage("http://localhost:8888/profile/upload/2024/07/22/channels4_profile_20240722155536A001.jpg");
        updateDTO.setContent("test4");
        Article article = BeanUtil.copyProperties(updateDTO, Article.class);
        article.setArticleId(updateDTO.getId());
        articleService.updateById(article);
    }

    @Test
    void selectByArticleIdTest() {
        Result result = articleService.selectByArticleId(3L);
        System.out.println(result.getData());
    }
}
