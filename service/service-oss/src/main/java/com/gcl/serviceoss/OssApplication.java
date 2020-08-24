package com.gcl.serviceoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: gcl
 * @create: 2020/7/30 15:48
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //可能会出现数据源相关的错误，排除掉就好了
@ComponentScan({"com.gcl"})
@EnableDiscoveryClient
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}
