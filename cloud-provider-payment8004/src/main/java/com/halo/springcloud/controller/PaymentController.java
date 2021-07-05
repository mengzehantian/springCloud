package com.halo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author halo
 * @date 2021/7/2 18:51
 * @description
 */
@RestController
//@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/zk")
    public String paymentZk(){
        return "SpringCloud with zookeeper:" +serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
