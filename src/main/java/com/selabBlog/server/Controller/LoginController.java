package com.selabBlog.server.Controller;


import com.selabBlog.pojo.DTO.LoginDTO;
import com.selabBlog.pojo.Result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public Result<String> login(@RequestBody  LoginDTO loginDTO){
        return null;
    }




}
