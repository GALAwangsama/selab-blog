package com.selabBlog.server.Controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.generator.Generator;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.CaptchaImageVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static com.selabBlog.common.constant.RedisConstant.LOGIN_CONSTANT;


@RestController
@Slf4j
@RequestMapping("/captchaImage")
public class CaptchaImageController {


    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 获取图片验证码和uuid
     * @return
     */
    @GetMapping
    public Result<CaptchaImageVO> captchaImage() {

        //生成图片验证码
        CircleCaptcha Captcha = CaptchaUtil.createCircleCaptcha(200, 100,4,30);

        // 生成code
        Captcha.createCode();
        String code = Captcha.getCode();
        //将验证码转为字符串
        String image = Captcha.getImageBase64();
        
        //生成随机uuid
        String uuid = UUID.randomUUID().toString();
        //将验证码code，uuid存到redis中

        //TODO 将时间改回60
        //以uuid为唯一验证
        redisTemplate.opsForValue().set(LOGIN_CONSTANT+uuid,code,6000, TimeUnit.SECONDS);

        log.info("uuid：{}，code：{}",uuid,code);

        //创建VO对象返回
        CaptchaImageVO captchaImageVO = CaptchaImageVO
                .builder()
                .img(image)
                .uuid(uuid)
                .build();


        return Result.success(captchaImageVO);
    }
}
