package com.selabBlog.server.Service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.selabBlog.pojo.entity.Article;
import com.selabBlog.pojo.entity.Behaviour;
import com.selabBlog.server.Mapper.ArticleMapper;
import com.selabBlog.server.Mapper.BehaviourMapper;
import com.selabBlog.server.Service.ArticleService;
import com.selabBlog.server.Service.BehaviourService;
import org.springframework.stereotype.Service;

@Service
public class BehaviourServiceImpl extends ServiceImpl<BehaviourMapper, Behaviour> implements BehaviourService {
}
