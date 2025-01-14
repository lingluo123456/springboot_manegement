package com.zzs.controller;


import com.zzs.pojo.EmpJobCount;
import com.zzs.pojo.Result;
import com.zzs.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 员工职位人数统计
     */
    @GetMapping("/empJobData")
    public Result empJobData(){
        log.info("员工职位人数统计");
        EmpJobCount empJobCount = reportService.getEmpJobData();
        return Result.success(empJobCount);
    }

    /**
     * 员工性别统计
     */
    @GetMapping("/empGenderData")
    public Result GenderData(){
        log.info("员工性别统计");
        List<Map<String, Object>> genderData=reportService.getGenderData();
        return Result.success(genderData);

    }
}