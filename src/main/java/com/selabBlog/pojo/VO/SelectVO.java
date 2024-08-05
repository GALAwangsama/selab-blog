package com.selabBlog.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectVO {

    private Long id;

    private Long userId;

    private String title;

    private String content;

    private String username;

    private String image;

    private Integer articleLike;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishTime;

    private Long commentCount;



}
