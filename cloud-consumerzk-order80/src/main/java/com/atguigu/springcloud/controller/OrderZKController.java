package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/3/30 23:30
 */
@RestController
@Slf4j
public class OrderZKController {

    public static final String PAYMENT_URL ="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }

}
