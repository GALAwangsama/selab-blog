package com.selabBlog.server.Controller;


import com.selabBlog.pojo.DTO.AddCommentDTO;
import com.selabBlog.pojo.DTO.IsLikeDTO;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.SelectCommentVO;
import com.selabBlog.server.Service.BehaviourService;
import com.selabBlog.server.Service.CommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/behavior")
public class BehaviourController {


    @Resource
    private BehaviourService behaviourService;

    @Resource
    private CommentService commentService;

    //TODO 点赞，取消点赞
    @PostMapping("/likeOperate")
    public Result isLike(@RequestBody IsLikeDTO isLikeDTO){
        return null;
    }

    //TODO 查看所有评论
    @GetMapping("/listComment/{id}")
    public Result<List<SelectCommentVO>> selectComment(@PathVariable Long id){
        return null;
    }

    //TODO 新增评论
    @PostMapping("/addComment")
    public Result addComment(@RequestBody AddCommentDTO addCommentDTO){
        return null;
    }

    //TODO 删除评论
    @DeleteMapping("/deleteComment/{id}")
    public Result deleteComment(@PathVariable Long id){
        return null;
    }














}
