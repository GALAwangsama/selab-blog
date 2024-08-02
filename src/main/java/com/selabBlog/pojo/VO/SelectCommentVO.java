package com.selabBlog.pojo.VO;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class SelectCommentVO {

    private String comment;

    private LocalDateTime createTime;

    private Long userId;

    private String userName;

}
