package com.atguigu.springcloud.service;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/18 17:15
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
