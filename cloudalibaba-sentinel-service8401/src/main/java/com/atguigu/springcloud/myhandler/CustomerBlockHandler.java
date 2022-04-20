package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/17 21:38
 */
public class CustomerBlockHandler {

    public static String handleExceptionC(BlockException exception){
        return "handleException---C";
    }

}
