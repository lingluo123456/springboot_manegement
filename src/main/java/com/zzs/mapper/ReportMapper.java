package com.zzs.mapper;


import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface ReportMapper {


    //加上@MapKey()是为了解决mybatisx的误报，使用的是list集合，根本不用使用@MapKey
    @MapKey("pos")
    List<Map<String, Object>> countOfJob();
    //加上@MapKey()是为了解决mybatisx的误报，使用的是list集合，根本不用使用@MapKey
    @MapKey("gender")
    List<Map<String, Object>> getGenderData();
}
