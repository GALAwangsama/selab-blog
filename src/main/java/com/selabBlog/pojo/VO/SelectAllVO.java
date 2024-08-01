package com.selabBlog.pojo.VO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelectAllVO extends SelectVO{

    private Long userId;

    private Long commentCount;

}
