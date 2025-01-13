package com.zzs.service.impl;


import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzs.mapper.EmpExprMapper;
import com.zzs.mapper.EmpMapper;
import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpExpr;
import com.zzs.pojo.EmpQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;



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

    /**
     * 新增员工
     */
    @Transactional(rollbackFor = {Exception.class})//事务控制注解，出现所有异常都回滚
    @Override
    public void add(Emp emp) {
        //1.保存员工的基本信息
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
        //2.保存员工的工作经历
        if (!CollectionUtils.isEmpty(emp.getExprList())){
            emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.add(emp.getExprList());
        }
    }

    /**
     * 批量删除员工
     * @param ids
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        if(!CollectionUtils.isEmpty(ids)){
            empMapper.deleteByids(ids);
            empExprMapper.deleteByEmpids(ids);
        }
    }
    /**
     * 根据id查询员工
     */
    @Override
    public Emp findById(Integer id) {
        return empMapper.findById(id);
    }
    /**
     * 更新员工
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        empExprMapper.deleteByEmpids(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.add(exprList);
        }
    }
}