package com.gcl.serviceorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @Author: gcl
 * @create: 2020/8/16 10:41
 */

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.gcl")
@MapperScan("com.gcl.serviceorder.mapper")
@EnableFeignClients
public class OrdersApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }
}
