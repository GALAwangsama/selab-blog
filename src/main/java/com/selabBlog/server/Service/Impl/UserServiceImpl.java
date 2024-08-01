package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.pojo.entity.User;
import com.selabBlog.server.Mapper.ArticleMapper;
import com.selabBlog.server.Mapper.UserMapper;
import com.selabBlog.server.Service.ArticleService;
import com.selabBlog.server.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
