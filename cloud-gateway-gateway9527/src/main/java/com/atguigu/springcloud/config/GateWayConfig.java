package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LI QX
 * @Description: 通过网关9527 跳转到 百度国内新闻网
 * @Date: 2022/4/6 21:54
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                predicateSpec -> predicateSpec.path("/guonei")
                        .uri("http://news.baidu.com/guonei")
        ).build();

        return routes.build();
    }

}
