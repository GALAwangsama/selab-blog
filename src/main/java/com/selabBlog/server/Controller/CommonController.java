package com.selabBlog.server.Controller;


import com.selabBlog.common.exception.CommonException;
import com.selabBlog.pojo.Result.Result;
import com.selabBlog.pojo.VO.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.management.ObjectName;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.selabBlog.common.constant.CommonConstant.*;

@RestController
@Slf4j
@RequestMapping("/common")
public class CommonController {

    /**
     * 文件上传
      * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<FileVO> upload(@RequestBody MultipartFile file){
        //检测上传是否为空
        if (file.isEmpty()) {
            throw new CommonException(FILE_ISNULL);
        }

        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //用uuid重命名文件
            String ObjectName = UUID.randomUUID().toString()+extension;


            //创建文件传输目录
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String filePath = UPLOAD_DIR + ObjectName;
            String fileName = UPLOAD_DIR_RELATIVE+ObjectName;
            String url = URL+ObjectName;
            File destinationFile = new File(filePath);
            file.transferTo(destinationFile);


            FileVO fileVO = FileVO
                    .builder()
                    .FileName(fileName)
                    .newFileName(ObjectName)
                    .originalFileName(originalFilename)
                    .url(url)
                    .build();

            log.info("文件上传：{}",fileVO);
            return Result.success(fileVO);
        } catch (Exception e) {
            throw new CommonException(UPLOAD_FAILED);
        }


    }

}
