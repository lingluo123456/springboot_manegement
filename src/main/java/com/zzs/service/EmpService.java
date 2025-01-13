package com.zzs.service;

import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {


    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void add(Emp emp);

    void delete(List<Integer> ids);

    Emp findById(Integer id);

    void update(Emp emp);

    List<Emp> list();
}
