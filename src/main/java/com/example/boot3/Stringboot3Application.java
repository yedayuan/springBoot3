package com.example.boot3;

import jakarta.annotation.Resource;
import lombok.Value;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


import java.security.Key;
import java.util.*;


@ServletComponentScan //开始servler组件支持,开始过滤器支持
@SpringBootApplication
@MapperScan(basePackages = "com.example.boot3.users.Mapper")//连接数据库 连接接口

public class Stringboot3Application {

    public static void main(String[] args) {
        SpringApplication.run(Stringboot3Application.class, args);
    }

}
