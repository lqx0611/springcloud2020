package com.atguigu.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author: LI QX
 * @Description:
 * @Date: 2022/4/7 0:57
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    //过滤处理
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       log.info("*********come in MyLogGateWayFilter:"+new Date());

       String uname = exchange.getRequest().getQueryParams().getFirst("uname");

       if(StringUtils.isBlank(uname)){
           log.info("****用户名为null，非法用户******");
           exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
           return exchange.getResponse().setComplete();
       }

        return chain.filter(exchange);
    }

    //执行顺序
    @Override
    public int getOrder() {
        return 0;
    }
}
