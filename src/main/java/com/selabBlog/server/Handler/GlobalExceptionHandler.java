package com.selabBlog.server.Handler;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.selabBlog.common.exception.BaseException;
import com.selabBlog.pojo.Result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

import static com.selabBlog.common.constant.RegistConstant.ALREADY_EXISTS;
import static com.selabBlog.common.constant.RegistConstant.UNKNOWN_ERROR;


/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error("未知异常");
    }

    //TODO 解决sql异常不被拦截的问题
    /**
     * 处理SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        if(message.contains("Duplicate entry")){
            String[] split = message.split(" ");
            String userName = split[2];
            String msg = userName + ALREADY_EXISTS;
            return Result.error(msg);

        }else{
            return Result.error(UNKNOWN_ERROR);
        }
    }

}
