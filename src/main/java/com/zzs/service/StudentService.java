package com.zzs.service;

import com.zzs.pojo.PageResult;
import com.zzs.pojo.Student;
import com.zzs.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);


    void add(Student student);

    void delete(Integer[] ids);

    Student findById(Integer id);

    void update(Student student);

    void violation(Integer id, Integer score);
}
