package com.selabBlog.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Long behaviourId;

    private Long articleId;

    private Long userId;

    private Integer isLike;

}
