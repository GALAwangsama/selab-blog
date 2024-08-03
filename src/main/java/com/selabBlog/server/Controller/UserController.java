package com.selabBlog.server.Controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.codec.Base64;
import com.selabBlog.pojo.DTO.RegistDTO;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.server.Service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 用户注册
     * @param registDTO
     * @return
     */
    @PostMapping("/regist")
    public Result regist(@RequestBody RegistDTO registDTO){

        log.info("注册:{}",registDTO);
        userService.regist(registDTO);
        Result result = new Result();
        result.setMsg("操作成功");
        result.setCode(200);
        return result;
    }


}
