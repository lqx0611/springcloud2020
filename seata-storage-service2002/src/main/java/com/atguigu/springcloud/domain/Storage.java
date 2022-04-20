package com.atguigu.springcloud.domain;

import lombok.Data;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/18 16:56
 */

@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
