package com.selabBlog.pojo.DTO;


import lombok.Data;

@Data
public class UpdateDTO {

    //文章id
    private Long id;

    private String title;

    private String content;

    private String image;



}
