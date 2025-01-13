package com.zzs.controller;


import com.zzs.pojo.Clazz;
import com.zzs.pojo.ClazzQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.pojo.Result;
import com.zzs.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {


    @Autowired
    private ClazzService clazzService;

    /**
     * 根据条件分页查询班级信息
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("查询班级信息，参数：{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加班级信息
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级信息，参数：{}",clazz);
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzService.add(clazz);
        return Result.success();
    }
}

