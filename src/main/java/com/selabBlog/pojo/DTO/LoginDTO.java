package com.selabBlog.pojo.DTO;


import lombok.Data;


@Data

public class LoginDTO {

    private String code;

    private String password;

    private String username;

    private String uuid;

}
