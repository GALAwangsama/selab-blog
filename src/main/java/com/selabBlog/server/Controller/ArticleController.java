package com.selabBlog.server.Controller;


import com.selabBlog.pojo.DTO.SaveArticleDTO;
import com.selabBlog.pojo.DTO.UpdateDTO;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.SelectAllVO;
import com.selabBlog.pojo.VO.SelectArticleVO;
import com.selabBlog.pojo.VO.SelectVO;
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
        return null;
    }

    //TODO 选择文章
    @GetMapping("selectByArticleId/{id}")
    public Result<SelectArticleVO> selectByArticle(@PathVariable Long id){
        return null;
    }

    //TODO 删除文章
    @DeleteMapping("/deleteArticle/{id}")
    public Result delete(@PathVariable Long id){
        return null;
    }

    //TODO 修改文章
    @PutMapping("/updateArticle")
    public Result update(@RequestBody UpdateDTO updateDTO){
        return null;
    }

    //TODO 查询文章详情
    @GetMapping("/articleDetails/{aid}")
    public Result<SelectAllVO> details(@PathVariable Long aid){

        Result result = articleService.articleDetails(aid);
        return result;

    }


}
