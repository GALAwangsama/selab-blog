package com.selabBlog.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {

    private String SecretKey = "selab_blog";
    private long Ttl = 86400000;//24小时
    private String TokenName;



}
