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
    List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    void add(Emp emp);


    void deleteByids(List<Integer> ids);

    Emp findById(Integer id);

    void update(Emp emp);
}
