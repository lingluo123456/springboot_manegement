package com.zzs.service;

import com.zzs.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept findById(Integer id);
}
