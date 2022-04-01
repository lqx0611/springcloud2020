package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/3/29 21:45
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul 或者 zookeeper 作为注册中心时注册服务
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
