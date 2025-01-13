package com.zzs.service;

import com.zzs.pojo.Clazz;
import com.zzs.pojo.ClazzQueryParam;
import com.zzs.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);

    void deleteById(Integer id);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    List<Clazz> list();
}
