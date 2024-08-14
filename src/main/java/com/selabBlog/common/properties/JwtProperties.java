package com.selabBlog.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {

    private String SecretKey = "selab_blog";
    //24小时
    private long Ttl = 86400000;

    private String TokenName = "Authorization";



}
