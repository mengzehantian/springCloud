package com.halo.springcolud.controller;

import com.halo.springcolud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_Ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_Ok(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String payment_timeout(@PathVariable("id") Integer id){
        int num = 10/0;
        String result = paymentHystrixService.payment_timeout(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(Integer id){
        return "消费者80，对方支付系统繁忙，请十秒钟后再试或者自己运行错误，请检查自己o(T__T)o";
    }

    /**
     * 全局fallback方法
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试";
    }
















}
