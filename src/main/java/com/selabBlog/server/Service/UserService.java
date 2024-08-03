package com.selabBlog.server.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.selabBlog.pojo.DTO.LoginDTO;
import com.selabBlog.pojo.DTO.RegistDTO;
import com.selabBlog.pojo.entity.User;

public interface UserService extends IService<User> {


    String login(LoginDTO loginDTO);

    void regist(RegistDTO registDTO);
}
