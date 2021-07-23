package com.halo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author halo
 * @date 2021/7/23 18:56
 * @description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class,args);
    }
}
