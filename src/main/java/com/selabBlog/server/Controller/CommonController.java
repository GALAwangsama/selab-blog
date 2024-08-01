package com.selabBlog.server.Controller;


import com.selabBlog.pojo.VO.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.FileVisitOption;

@RestController
@Slf4j
@RequestMapping("/common")
public class CommonController {

    //TODO 文件上传
    @PostMapping("/upload")
    public FileVO upload(){
        return null;
    }

}
