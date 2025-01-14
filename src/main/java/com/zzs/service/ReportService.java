package com.zzs.service;

import com.zzs.pojo.EmpJobCount;

import java.util.List;
import java.util.Map;

public interface ReportService {
    EmpJobCount getEmpJobData();

    List<Map<String, Object>> getGenderData();

    List<Map<String, Object>> getStudentDegreeData();

    List<Map<String, Object>> getStudentCountData();
}
