package com.zzs.mapper;

import com.zzs.pojo.Clazz;
import com.zzs.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);
}
