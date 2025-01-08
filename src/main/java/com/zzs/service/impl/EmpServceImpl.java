package com.zzs.service.impl;


import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzs.mapper.EmpMapper;
import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;



    /**
     * 基于PageHelper插件实现条件分页查询
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        /**
         * 方式二：使用PageHelper的静态方法，传入当前页码和每页记录数，调用startPage方法，传入一个ISelect接口的实现类，实现查询功能，返回Page对象
         */
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> pageInfo=(Page<Emp>)empList;
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());

    }
}