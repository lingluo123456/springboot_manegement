package com.zzs.controller;


import com.zzs.pojo.Emp;
import com.zzs.pojo.LoginInfo;
import com.zzs.pojo.Result;
import com.zzs.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        LoginInfo loginInfo =empService.login(emp);
        if (loginInfo==null){
            return Result.error("用户名或密码错误");
        }
        log.info("登录成功,{}",emp);
        return Result.success(loginInfo);
    }
}
