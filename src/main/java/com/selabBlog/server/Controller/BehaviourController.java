package com.selabBlog.server.Controller;


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

    //TODO 点赞，取消点赞
    @PostMapping("/likeOperate")
    public Result isLike(@RequestBody IsLikeDTO isLikeDTO){

        if(isLikeDTO.getIsLike() == 1) {
            Behaviour isLike = behaviourService.getById(isLikeDTO.getArticleId());
            Article article = new Article();
            article.setArticleId(isLike.getArticleId());
            article.setArticleLike(isLike.getIsLike() + 1);
            if(articleService.updateById(article)){
                return Result.success();
            }
        }
        Behaviour isLike = behaviourService.getById(isLikeDTO.getArticleId());
        Article article = new Article();
        article.setArticleId(isLike.getArticleId());
        article.setArticleLike(isLike.getIsLike() - 1);
        if(articleService.updateById(article)){
            return Result.success();
        }
        Result<Object> result = new Result<>();
        result.setCode(501);
        result.setMsg("");
        return result;
    }

    //TODO 查看所有评论
    @GetMapping("/listComment/{id}")
    public Result<List<SelectCommentVO>> selectComment(@PathVariable Long id){
        List<Comment> comments = commentService.list();
        List<SelectCommentVO> selectCommentVOList = new ArrayList<>();
        for(Comment comment : comments){
            selectCommentVOList.add(commentService.byUseridToSelectCommentVo(comment.getUserId()));
        }
        return Result.success(selectCommentVOList);
    }

    //TODO 新增评论
    //此处请求数据少一个userid，暂定为手动输入,值为1
    @PostMapping("/addComment")
    public Result addComment(@RequestBody AddCommentDTO addCommentDTO){
        Comment comment = new Comment();
        comment.setCommentBody(addCommentDTO.getComment());
        comment.setArticleId(addCommentDTO.getArticleId());
        comment.setCreateTime(LocalDateTime.now());
        //此处userid定为1
        comment.setUserId(1L);
        if(commentService.save(comment)){
            return Result.success();
        };
        return Result.error("501");
    }

    //TODO 删除评论
    @DeleteMapping("/deleteComment/{id}")
    public Result deleteComment(@PathVariable Long id){
        if(commentService.removeById(id)){
            return Result.success();
        }
        return Result.error("501");
    }
}
