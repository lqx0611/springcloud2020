package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/3/20 17:04
 */
@RestController
@Slf4j
@RequestMapping("/consumer/")
public class OrderController {

//    public static final String PAYMENT_URL ="http://localhost:8001";
    public static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable Long id){
        restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+","+entity.getHeaders());
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"miss op");
        }
    }


}
