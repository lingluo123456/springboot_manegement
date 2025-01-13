package com.zzs.controller;


import com.zzs.pojo.PageResult;
import com.zzs.pojo.Result;
import com.zzs.pojo.Student;
import com.zzs.pojo.StudentQueryParam;
import com.zzs.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /**
     * 分页条件查询
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页条件查询，参数：{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加学员
     */
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学员，参数：{}",student);
        studentService.add(student);
        return Result.success();
    }
    /**
     * 删除学员
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") Integer[] ids){
        log.info("删除学员，参数：{}",ids);
        studentService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询学员
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询员工{}",id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    /**
     * 更新学员
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新员工，参数：{}",student);
        studentService.update(student);
        return Result.success();
    }
    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,@PathVariable Integer score){
        log.info("违纪处理，参数：{}",id);
        studentService.violation(id,score);
        return Result.success();
    }
}
