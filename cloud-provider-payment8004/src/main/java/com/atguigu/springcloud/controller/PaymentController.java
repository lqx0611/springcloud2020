package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/3/29 21:59
 */
@RestController
@RequestMapping("/payment/")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("zk")
    public String paymentzk(){
        return "sptingcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
