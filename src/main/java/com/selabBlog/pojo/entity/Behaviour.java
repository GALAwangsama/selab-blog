package com.selabBlog.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@TableName("behaviour")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Behaviour {

    private Long behaviourId;

    private Long articleId;

    private Long userId;

    private Integer isLike;

}
