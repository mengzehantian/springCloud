package com.halo.springcolud.controller;

import com.halo.springcolud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author halo
 * @date 2021/7/14 19:32
 * @description
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_Ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_Ok(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_timeout(id);
        return result;
    }


















}
