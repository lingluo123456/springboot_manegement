package com.zzs.service;

import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
    /**
     * 新增员工
     */
    void add(Emp emp);
}
