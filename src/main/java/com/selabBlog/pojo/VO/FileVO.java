package com.selabBlog.pojo.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileVO {

    private String FileName;

    private String newFileName;

    private String url;

    private String originalFileName;

}
