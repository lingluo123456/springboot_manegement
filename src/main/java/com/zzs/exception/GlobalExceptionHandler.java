package com.zzs.exception;

import com.zzs.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     */
    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("服务器发生异常：{}", e.getMessage());
        return Result.error("服务器发生异常,请联系管理员");
    }



}
