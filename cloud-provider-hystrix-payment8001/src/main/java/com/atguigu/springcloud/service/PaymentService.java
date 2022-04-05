package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/5 16:42
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return"线程池:"+Thread.currentThread().getName()+" paymentInfo_OK ,id: "+id;
    }

    public String paymentInfo_timeout(Integer id){
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return"线程池:"+Thread.currentThread().getName()+
                " paymentInfo_timeout ,id: "+id+",耗时(s)："+timeout;
    }
}
