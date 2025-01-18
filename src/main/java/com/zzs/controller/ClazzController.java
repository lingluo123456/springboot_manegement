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
import java.util.List;

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
        if(clazz.getBeginDate().isAfter(clazz.getEndDate()))return Result.error("开始日期不能在结束日期之前");
        log.info("添加班级信息，参数：{}",clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    /**
     * 删除班级信息
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("删除班级信息，参数：{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("查询班级信息，参数：{}",id);
        Clazz clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        if(clazz.getBeginDate().isAfter(clazz.getEndDate()))return Result.error("开始日期不能在结束日期之前");
        log.info("修改班级信息，参数：{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }

}

