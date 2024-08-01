package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.entity.User;
import com.selabBlog.server.Mapper.LoginMapper;
import com.selabBlog.server.Service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {
}
