package com.selabBlog.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName("comment")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long commentId;

    private Long articleId;

    private Long userId;

    private String commentBody;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
