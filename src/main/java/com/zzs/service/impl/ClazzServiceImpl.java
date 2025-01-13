package com.zzs.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzs.mapper.ClazzMapper;
import com.zzs.pojo.Clazz;
import com.zzs.pojo.ClazzQueryParam;
import com.zzs.pojo.PageResult;
import com.zzs.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService{

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 根据条件分页查询班级信息
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        clazzList.forEach(clazz -> {
            if(clazz.getBeginDate().isAfter(LocalDate.now())){
                clazz.setStatus("未开班");
            }else if (clazz.getEndDate().isBefore(LocalDate.now())){
                clazz.setStatus("已结课");
            }else {
                clazz.setStatus("在读中");
            }
        });
        Page<Clazz> pageInfo=(Page<Clazz>)clazzList;
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());
    }

    /**
     *添加班级信息
     */
    @Override
    public void add(Clazz clazz) {
        clazzMapper.add(clazz);
    }
}
