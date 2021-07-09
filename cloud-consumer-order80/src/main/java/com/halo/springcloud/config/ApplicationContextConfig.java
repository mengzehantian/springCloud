package com.halo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author halo
 * @date 2021/6/30 13:53
 * @description
 */
@Configuration
public class ApplicationContextConfig {

    /**
     *  使用@LoadBalanced 注解，赋予RestTemplate 负载均衡能力
     * @return
     */
    @Bean
   // @LoadBalanced  //取消使用默认负载均衡模式
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
