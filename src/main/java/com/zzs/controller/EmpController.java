package com.zzs.controller;


import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.pojo.Result;
import com.zzs.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {


    @Autowired
    private EmpService empService;
    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }


}
