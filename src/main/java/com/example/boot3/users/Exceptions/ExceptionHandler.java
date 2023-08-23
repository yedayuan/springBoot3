package com.example.boot3.users.Exceptions;

import com.example.boot3.users.Results.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//全局异常处理
public class ExceptionHandler {

/*全局异常类*/
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("全局异常处理出现异常");
    }
}