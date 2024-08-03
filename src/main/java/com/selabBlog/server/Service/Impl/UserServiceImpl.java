package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.common.Utils.JwtUtil;
import com.selabBlog.common.exception.LoginException;
import com.selabBlog.common.properties.JwtProperties;
import com.selabBlog.pojo.DTO.LoginDTO;
import com.selabBlog.pojo.DTO.RegistDTO;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.pojo.entity.User;
import com.selabBlog.server.Mapper.ArticleMapper;
import com.selabBlog.server.Mapper.UserMapper;
import com.selabBlog.server.Service.ArticleService;
import com.selabBlog.server.Service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.selabBlog.common.constant.LoginConstant.*;
import static com.selabBlog.common.constant.RedisConstant.LOGIN_CONSTANT;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 登录
     * @param loginDTO
     * @return
     */
    public String login(LoginDTO loginDTO) {


        //进行登录校验
        String code = loginDTO.getCode();
        String uuid = loginDTO.getUuid();
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        //获取保存的code和uuid
        String redisCode =(String) redisTemplate.opsForValue().get(LOGIN_CONSTANT+uuid);

        //验证uuid
        if(redisCode==null){
            throw new LoginException(VERIFICATION_CODE);
        }

        //校验验证码
        if (!(code.equals(redisCode))){
            throw new LoginException(CODE_FAILED);
        }

        //比对数据库
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name",username);
        User user = userMapper.selectOne(wrapper);

        //判断用户是否存在
        if(user == null){
            throw new LoginException(USERNAME_NOT_FOUND);
        }
        //校验密码
        if(!(password.equals(user.getPassword()))){
            throw new LoginException(PASSWORD_FAILED);
        }

        Long userId = user.getUserId();

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId",userId);
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims);



        return token;
    }

    /**
     * 注册
     * @param registDTO
     */
    @Override
    public void regist(RegistDTO registDTO) {

        User user = User
                .builder()
                .userName(registDTO.getUsername())
                .password(registDTO.getPassword())
                .phone(registDTO.getPhone())
                .email(registDTO.getEmail())
                .sex(registDTO.getSex())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .status(1)
                .build();

        save(user);

    }
}
