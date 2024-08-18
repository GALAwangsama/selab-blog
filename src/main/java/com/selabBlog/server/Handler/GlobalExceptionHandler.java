package com.selabBlog.server.Handler;

import com.selabBlog.common.exception.BaseException;
import com.selabBlog.common.exception.InputException;
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
        return Result.error(ex.getMessage());
    }


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

    /**
     * 处理输入数据异常
     * @return result
     */
    @ExceptionHandler(InputException.class)
    public Result InputExceptionHandler(){
        Result<Object> result = new Result<>();
        result.setMsg("输入数据违法");
        result.setCode(501);
        return result;
    }

}
