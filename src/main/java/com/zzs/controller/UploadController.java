package com.zzs.controller;

import com.zzs.pojo.Result;
import com.zzs.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j
@RestController
public class UploadController {
    /**
     * 本地磁盘存储方案
     */

    /*@PostMapping("/upload")
    public Result upload(String name , Integer age , @RequestParam("file") MultipartFile file) throws Exception {
        log.info("name:{},age:{},file:{}",name,age,file);
        file.transferTo(new File("D:\\javalearn\\javaweb\\image\\"+file.getOriginalFilename()));
        return Result.success();
    }*/

    /**
     * 阿里云OSS存储方案
     */

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("file:{}",file.getOriginalFilename());
        String url=aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("url:{}",url);
        return Result.success(url);
    }
}
