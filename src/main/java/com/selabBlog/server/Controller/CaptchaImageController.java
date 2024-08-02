package com.selabBlog.server.Controller;


import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.CaptchaImageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/captchaImage")
public class CaptchaImageController {

    //TODO 获取图片验证码和uuid
    @GetMapping
    public Result<CaptchaImageVO> captchaImage(){
        return null;
    }





}
