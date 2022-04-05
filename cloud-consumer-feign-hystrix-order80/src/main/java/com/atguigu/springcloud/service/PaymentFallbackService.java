package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/5 22:41
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentOk(Integer id) {
        return "impl系统繁忙ok";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "impl系统繁忙timeout";
    }
}
