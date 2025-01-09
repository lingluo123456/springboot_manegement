package com.zzs.mapper;

import com.zzs.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入
     * @param exprList
     */
    void add(List<EmpExpr> exprList);
}
