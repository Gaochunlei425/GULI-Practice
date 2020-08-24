package com.gcl.cmsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gcl
 * @create: 2020/8/10 13:03
 */

@SpringBootApplication
@ComponentScan({"com.gcl"}) //指定扫描位置
@MapperScan("com.gcl.cmsservice.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
