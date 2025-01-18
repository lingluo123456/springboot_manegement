package com.zzs.controller;

import com.zzs.anno.Log;
import com.zzs.pojo.Dept;
import com.zzs.pojo.Result;
import com.zzs.service.DeptService;
import com.zzs.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class   DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result list() {
        log.info("查询部门所有数据");
        List<Dept> depts=deptService.findAll();
        return Result.success(depts);
    }
    /**
     * 删除部门
     */
    @Log
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer id) {
        if (empService.findByDempId(id))return Result.error("该部门下有员工，不能删除");
        log.info("删除部门");
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 添加部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门");
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据id查询部门,可以做查询回显用
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
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门");
        deptService.update(dept);
        return Result.success();
    }

}
