package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/17 13:51
 */
@RestController
public class FlowLimitController
{

    @GetMapping("/testA")
    @SentinelResource(value = "testA",blockHandler = "testABack")
    public String testA()
    {
        return "------testA";
    }
    public String testABack(BlockException b)
    {
        return "------testABack";
    }


    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testC",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleExceptionC")
    public String testC()
    {
        return "------testC";
    }
}

