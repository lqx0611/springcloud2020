package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
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
 * @Date: 2022/4/5 16:49
 */
@RestController
@Slf4j

public class PaymentController {

    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("--result:"+result);
        return result;
    }


    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentTimeout(@PathVariable("id") Integer id){
        //int a = 10/0;
        String result = paymentService.paymentInfo_timeout(id);
        log.info("--result:"+result);
        return result;
    }

    public String timeoutFallbackMethod(@PathVariable("id") Integer id){
        return "系统繁忙";
    }


}
