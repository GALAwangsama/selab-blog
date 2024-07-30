package com.selabBlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.selabBlog.server.Mapper")
@EnableTransactionManagement
@EnableWebMvc
@SpringBootApplication
public class SelabBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelabBlogApplication.class, args);
    }

}
