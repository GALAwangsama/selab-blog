package com.selabBlog.pojo.DTO;


import lombok.Data;

@Data
public class AddCommentDTO {

    private String comment;

    private Long articleId;

}
