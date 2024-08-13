package com.selabBlog.server.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.selabBlog.pojo.VO.SelectCommentVO;
import com.selabBlog.pojo.entity.Comment;

public interface CommentService extends IService<Comment> {
    /**
     * 通过用户id查询 用户评论信息
     * 返回SelectCommentVo
     * @param userId
     * @return
     */
    SelectCommentVO byUseridToSelectCommentVo(Long userId);
}
