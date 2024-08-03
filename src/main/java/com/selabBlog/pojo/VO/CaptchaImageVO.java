package com.selabBlog.pojo.VO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaptchaImageVO {

    private String img;

    private String uuid;
}
