package com.zzs.service;

import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
    /**
     * 新增员工
     */
    void add(Emp emp);
    /**
     * 删除员工
     */
    void delete(List<Integer> ids);
}
