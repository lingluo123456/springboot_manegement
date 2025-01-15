package com.zzs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启Springboot对Servlet组件的支持
@SpringBootApplication
public class WebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagementApplication.class, args);
    }

}
