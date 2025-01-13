package com.zzs.mapper;

import com.zzs.pojo.Clazz;
import com.zzs.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> page(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);
    @Delete("delete from clazz where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from clazz where id = #{id}")
    Clazz findById(Integer id);

    void update(Clazz clazz);
    @Select("select * from clazz")
    List<Clazz> list();
}
