package com.selabBlog.pojo.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileVO {

    private String FileName;

    private String newFileName;

    private String url;

    private String originalFileName;

}
