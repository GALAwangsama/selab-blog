package com.selabBlog.server.Controller;

import com.selabBlog.pojo.DTO.RegistDTO;
import com.selabBlog.pojo.Result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @PostMapping("/regist")
    public Result regist(@RequestBody RegistDTO registDTO){
        return null;
    }


}
