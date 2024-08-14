package com.selabBlog.server.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.selabBlog.common.context.BaseContext;
import com.selabBlog.common.exception.InputException;
import com.selabBlog.pojo.DTO.AddCommentDTO;
import com.selabBlog.pojo.DTO.IsLikeDTO;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.SelectCommentVO;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.pojo.entity.Behaviour;
import com.selabBlog.pojo.entity.Comment;
import com.selabBlog.server.Service.ArticleService;
import com.selabBlog.server.Service.BehaviourService;
import com.selabBlog.server.Service.CommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/behavior")
public class BehaviourController {


    @Resource
    private BehaviourService behaviourService;
    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    //点赞，取消点赞
    @PostMapping("/likeOperate")
    public Result isLike(@RequestBody IsLikeDTO isLikeDTO){
        if(!(isLikeDTO.getIsLike() == 0) && !(isLikeDTO.getIsLike() == 1) || !(isLikeDTO.getArticleId() > 0)){
            throw new InputException();
        }


        //判断behaviour中是否有对应数据
        LambdaQueryWrapper<Behaviour> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Behaviour::getArticleId,isLikeDTO.getArticleId()).eq(Behaviour::getUserId, BaseContext.getCurrentId());
        Behaviour behaviour = behaviourService.getOne(wrapper);

        //新的用户行为数据
        Behaviour newBehaviour = new Behaviour();
        newBehaviour.setArticleId(isLikeDTO.getArticleId());
        newBehaviour.setIsLike(isLikeDTO.getIsLike());
        newBehaviour.setUserId(BaseContext.getCurrentId());

        //若没有则添加数据
        if (behaviour == null) {
            behaviourService.save(newBehaviour);

            //增加article的点赞值
            Article article = articleService.getById(isLikeDTO.getArticleId());
            article.setArticleLike(article.getArticleLike() + 1);
            articleService.updateById(article);
            return Result.success();
        }

        //若有则更改数据
        behaviour.setIsLike(isLikeDTO.getIsLike());
        if (isLikeDTO.getIsLike() == 1) {
            behaviourService.updateById(behaviour);
            //增加article的点赞值
            Article article = articleService.getById(isLikeDTO.getArticleId());
            article.setArticleLike(article.getArticleLike() + 1);
            articleService.updateById(article);
            return Result.success();
        }else {
            behaviourService.updateById(behaviour);
            //减少article的点赞值
            Article article = articleService.getById(isLikeDTO.getArticleId());
            article.setArticleLike(article.getArticleLike() - 1);
            articleService.updateById(article);
            return Result.success();
        }
    }

    //查看所有评论
    @GetMapping("/listComment/{id}")
    public Result<List<SelectCommentVO>> selectComment(@PathVariable Long id){
        if(!(id > 0)){
            throw new InputException();
        }

        List<Comment> comments = commentService.list();
        List<SelectCommentVO> selectCommentVOList = new ArrayList<>();
        for(Comment comment : comments){
            if(!Objects.equals(comment.getUserId(), id)){
                continue;
            }
            SelectCommentVO selectCommentVO = commentService.byUseridToSelectCommentVo(id);
            selectCommentVO.setComment(comment.getCommentBody());
            selectCommentVO.setCreateTime(comment.getCreateTime());
            selectCommentVOList.add(selectCommentVO);
        }
        return Result.success(selectCommentVOList);
    }

    //新增评论
    @PostMapping("/addComment")
    public Result addComment(@RequestBody AddCommentDTO addCommentDTO){
        if(!(addCommentDTO.getArticleId() > 0)){
            throw new InputException();
        }
        //增加文章的评论数
        Article article = articleService.getById(addCommentDTO.getArticleId());
        article.setCommentCount(article.getCommentCount() + 1);
        articleService.updateById(article);

        //增加评论
        Comment comment = new Comment();
        comment.setCommentBody(addCommentDTO.getComment());
        comment.setArticleId(addCommentDTO.getArticleId());
        comment.setCreateTime(LocalDateTime.now());
        comment.setUserId(BaseContext.getCurrentId());
        commentService.save(comment);
        return Result.success();
    }

    //删除评论
    @DeleteMapping("/deleteComment/{id}")
    public Result deleteComment(@PathVariable Long id){
        if(!(id > 0)){
            throw new InputException();
        }

        //减少文章的评论数
        Article article = articleService.getById(id);
        article.setCommentCount(article.getCommentCount() - 1);
        articleService.updateById(article);

        //删除评论
        commentService.removeById(id);
        return Result.success();


    }
}
