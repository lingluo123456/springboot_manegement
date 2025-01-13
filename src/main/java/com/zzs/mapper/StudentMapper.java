package com.zzs.mapper;

import com.zzs.pojo.Student;
import com.zzs.pojo.StudentQueryParam;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> page(StudentQueryParam studentQueryParam);


    void add(Student student);

    void delete(Integer[] ids);


    Student findById(Integer id);

    void update(Student student);
}
