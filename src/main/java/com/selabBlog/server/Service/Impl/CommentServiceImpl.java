package com.selabBlog.server.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.VO.SelectCommentVO;
import com.selabBlog.pojo.entity.Comment;
import com.selabBlog.server.Mapper.CommentMapper;
import com.selabBlog.server.Service.CommentService;
import com.selabBlog.server.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private UserService userService;


    @Override
    public SelectCommentVO byUseridToSelectCommentVo(Long userId) {
        Comment user = getById(userId);
        SelectCommentVO selectCommentVO = new SelectCommentVO();

        selectCommentVO.setUserName(userService.getById(user.getUserId()).getUserName());
        selectCommentVO.setComment(user.getCommentBody());
        selectCommentVO.setCreateTime(user.getCreateTime());
        selectCommentVO.setUserId(user.getUserId());

        return selectCommentVO;
    }
}
