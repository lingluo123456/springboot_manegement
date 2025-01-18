package com.zzs.controller;


import com.zzs.pojo.OperateLog;
import com.zzs.pojo.PageResult;
import com.zzs.pojo.Result;
import com.zzs.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/log")
public class LogController {

    @Autowired
    private OperateLogService operateLogService;
    @GetMapping("/page")
    public Result index(Integer page,Integer pageSize){
        log.info("分页查询，当前页码{},每页条数{}",page,pageSize);
        PageResult<OperateLog> pageResult = operateLogService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
