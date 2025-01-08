package com.zzs.controller;

import com.zzs.pojo.Dept;
import com.zzs.pojo.Result;
import com.zzs.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class   DeptController {

    @Autowired
    private DeptService deptService;

     @GetMapping
    public Result list() {
        log.info("查询部门所有数据");
        List<Dept> depts=deptService.findAll();
        return Result.success(depts);
    }


    /**
     * 删除部门
     */
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {
        log.info("删除部门");
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 添加部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门");
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        log.info("根据id查询部门{}",id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门");
        deptService.update(dept);
        return Result.success();
    }

}
