package com.selabBlog.server.Controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.selabBlog.common.context.BaseContext;
import com.selabBlog.pojo.DTO.SaveArticleDTO;
import com.selabBlog.pojo.DTO.UpdateDTO;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.SelectAllVO;
import com.selabBlog.pojo.VO.SelectArticleVO;
import com.selabBlog.pojo.VO.SelectVO;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.server.Service.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;


    //TODO 查询所有文章
    @GetMapping("/load")
    public Result<List<SelectVO>> load(){

        Result result = articleService.load();
        return result;
    }

    //TODO 查询用户的所有文章
    @GetMapping("/selectByUserId/{uid}")
    public  Result<List<SelectVO>> selectByUserId(@PathVariable Long uid){

        Result result = articleService.selectByUserId(uid);
        return result;

    }

    //TODO 新增文章
    @PostMapping("/saveArticle")
    public Result save(@RequestBody SaveArticleDTO saveArticleDTO){
        if(saveArticleDTO.getTitle() == null || saveArticleDTO.getContent() == null
                || saveArticleDTO.getImage() == null){
            return Result.error("信息填写不完整");
        }
        Article article = BeanUtil.copyProperties(saveArticleDTO, Article.class);
        article.setPublishTime(DateTime.now().toLocalDateTime());
        BaseContext baseContext = new BaseContext();
        Long userId = baseContext.getCurrentId();
        article.setUserId(userId);
        boolean flag = articleService.save(article);
        if (flag){
            return Result.success();
        }else {
            return Result.error("文章新增失败");
        }
    }

    //TODO 选择文章
    @GetMapping("selectByArticleId/{id}")
    public Result<SelectArticleVO> selectByArticleId(@PathVariable Long id){
        Result result = articleService.selectByArticleId(id);
        return result;
    }

    //TODO 删除文章
    @DeleteMapping("/deleteArticle/{id}")
    public Result delete(@PathVariable Long id){
        boolean flag = articleService.removeById(id);
        if(flag){
            return Result.success();
        }else{
            return Result.error("文章删除失败");
        }
    }

    //TODO 修改文章
    @PutMapping("/updateArticle")
    public Result update(@RequestBody UpdateDTO updateDTO){
        Article article = BeanUtil.copyProperties(updateDTO, Article.class);
        article.setUpdateTime(DateTime.now().toLocalDateTime());
        article.setArticleId(updateDTO.getId());
        boolean flag = articleService.updateById(article);
        if(flag){
            return Result.success();
        }else{
            return Result.error("文章修改失败");
        }
    }

    //TODO 查询文章详情
    @GetMapping("/articleDetails/{aid}")
    public Result<SelectAllVO> details(@PathVariable Long aid){

        Result result = articleService.articleDetails(aid);
        return result;

    }


}
