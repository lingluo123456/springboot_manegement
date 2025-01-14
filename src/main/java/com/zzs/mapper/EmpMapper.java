package com.zzs.mapper;

import com.zzs.pojo.Emp;
import com.zzs.pojo.EmpExpr;
import com.zzs.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> page(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    void add(Emp emp);


    void deleteByids(List<Integer> ids);

    Emp findById(Integer id);

    void update(Emp emp);

    @Select("select id, username, password, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp")
    List<Emp> list();

    @Select("select count(*) from emp where dept_id = #{id}")
    Integer findByDempId(Integer id);
}
