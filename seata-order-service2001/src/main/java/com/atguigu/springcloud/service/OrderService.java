package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/18 16:31
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
