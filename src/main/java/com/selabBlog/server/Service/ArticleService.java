package com.selabBlog.server.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.entity.Article;

public interface ArticleService extends IService<Article>{
    /**
     * 首页数据查询
     * @param
     * @return
     */
    Result load();

    /**
     * 根据文章id查询详情
     * @param aid
     * @return
     */


    Result articleDetails(Long aid);

    /**
     * 根据用户id查询文章
     * @param uid
     * @return
     */
    Result selectByUserId(Long uid);
}
