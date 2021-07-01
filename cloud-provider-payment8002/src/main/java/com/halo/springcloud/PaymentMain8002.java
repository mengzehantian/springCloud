package com.halo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author halo
 * @date 2021/6/30 9:54
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //配置服务发现discovery
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
