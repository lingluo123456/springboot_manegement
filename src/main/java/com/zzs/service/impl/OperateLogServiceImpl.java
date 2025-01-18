package com.zzs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzs.mapper.OperateLogMapper;
import com.zzs.pojo.OperateLog;
import com.zzs.pojo.PageResult;
import com.zzs.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> operateLogs = operateLogMapper.page();
        Page<OperateLog> pageInfo=(Page<OperateLog>)operateLogs;
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());
    }
}
