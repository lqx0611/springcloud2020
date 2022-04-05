package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/5 19:05
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_Fallback_Method")
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String s = paymentHystrixService.paymentOk(id);
        return s;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id){
        //int a =10/0;
        String s = paymentHystrixService.paymentTimeout(id);
        return s;
    }

    //指定的fallback，形参列表要一致
    public String timeoutFallbackMethod(@PathVariable("id") Integer id){
        return "系统繁忙";
    }

    public String payment_Global_Fallback_Method(){
        return "global系统繁忙";
    }
}
