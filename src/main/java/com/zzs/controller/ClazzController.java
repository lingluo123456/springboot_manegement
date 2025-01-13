package com.zzs.controller;


import com.zzs.pojo.Clazz;
import com.zzs.pojo.ClazzQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.pojo.Result;
import com.zzs.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result list(ClazzQueryParam clazzQueryParam){
        log.info("查询班级信息，参数：{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
}
