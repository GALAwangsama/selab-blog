package com.selabBlog.pojo.VO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectVO {

    private Long articleId;

    private String title;

    private String content;

    private String userName;

    private String image;

    private Integer articleLike;

    private LocalDateTime publishTime;



}
