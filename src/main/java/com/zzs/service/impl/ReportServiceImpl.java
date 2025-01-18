package com.zzs.service.impl;


import com.zzs.mapper.ReportMapper;
import com.zzs.pojo.ClazzStudentCount;
import com.zzs.pojo.EmpJobCount;
import com.zzs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {


    @Autowired
    private ReportMapper reportMapper;


    @Override
    public EmpJobCount getEmpJobData() {
        EmpJobCount empJobCount = new EmpJobCount();
        List<Map<String, Object>> jobcountList=reportMapper.countOfJob();
        empJobCount.setJobList(jobcountList.stream().map(stringObjectMap -> stringObjectMap.get("pos")).toList());
        empJobCount.setDataList(jobcountList.stream().map(stringObjectMap -> stringObjectMap.get("sum")).toList());
        return empJobCount;
    }


    @Override
    public List<Map<String, Object>> getGenderData() {
        return reportMapper.getGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return  reportMapper.getStudentDegreeData();
    }

    @Override
    public ClazzStudentCount getStudentCountData() {
        ClazzStudentCount clazzStudentCount = new ClazzStudentCount();
        List<Map<String, Object>> clazzData=reportMapper.getStudentCountData();
        clazzStudentCount.setClazzList(clazzData.stream().map(stringObjectMap -> stringObjectMap.get("pos")).toList());
        clazzStudentCount.setDataList(clazzData.stream().map(stringObjectMap -> stringObjectMap.get("sum")).toList());
        return clazzStudentCount;
    }
}
