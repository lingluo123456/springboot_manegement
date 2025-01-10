package com.zzs.controller;


import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.pojo.Result;
import com.zzs.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    /**
     * 新增员工
     */
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工{}",emp);
        empService.add(emp);
        return Result.success(emp);
    }
    /**
     *  删除员工
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询员工
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询员工{}",id);
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工{}",emp);
        empService.update(emp);
        return Result.success();
    }


}
