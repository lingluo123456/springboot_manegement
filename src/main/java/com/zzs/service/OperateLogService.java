package com.zzs.service;

import com.zzs.pojo.OperateLog;
import com.zzs.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
