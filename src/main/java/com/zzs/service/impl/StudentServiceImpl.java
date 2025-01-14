package com.zzs.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzs.mapper.StudentMapper;
import com.zzs.pojo.PageResult;
import com.zzs.pojo.Student;
import com.zzs.pojo.StudentQueryParam;
import com.zzs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询
     */
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> studentList = studentMapper.page(studentQueryParam);
        Page<Student> pageInfo=(Page<Student>)studentList;
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getResult());
    }



    @Override
    public void add(Student student) {
       student.setCreateTime(LocalDateTime.now());
       student.setUpdateTime(LocalDateTime.now());
       studentMapper.add(student);
    }

    @Override
    public void delete(Integer[] ids) {
        if(!(ids==null||ids.length==0)){
            studentMapper.delete(ids);
        }
    }


    @Override
    public Student findById(Integer id) {
      return  studentMapper.findById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }


    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void violation(Integer id, Integer score){
        Student student = studentMapper.findById(id);
        student.setViolationScore((short) (student.getViolationScore()+score));
        student.setViolationCount((short) (student.getViolationCount()+1));
        studentMapper.update(student);
    }
}
