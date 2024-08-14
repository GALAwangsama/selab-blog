package com.selabBlog.server.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.VO.SelectCommentVO;
import com.selabBlog.pojo.entity.Comment;
import com.selabBlog.pojo.entity.User;
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
        User newuser = userService.getById(userId);
        selectCommentVO.setUserName(newuser.getUserName());
        selectCommentVO.setUserId(userId);

        return selectCommentVO;
    }
}
