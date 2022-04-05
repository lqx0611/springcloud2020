package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/3/20 2:08
 */
@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***插入结果***："+result);
        if(result==1){
            return new CommonResult(000,"新增成功,serverPort:"+serverPort,result);
        }else {

            return new CommonResult(444,"新增失败",result);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        Payment paymentById = paymentService.getPaymentById(id);

        if(paymentById!=null){
            return new CommonResult(0,"查询成功,serverPort:"+serverPort,paymentById);
        }else {

            return new CommonResult(444,"查询失败，id:"+id,paymentById);
        }
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        instances.forEach(serviceInstance -> {
            System.out.println(serviceInstance.getHost()+"\t"+serviceInstance.getServiceId()
            +"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        });
        return discoveryClient;
    }
    @GetMapping("timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {


        }
        return serverPort;
    }
}
