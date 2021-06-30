package com.halo.springcloud.controller;

import com.halo.springcloud.util.CommonResult;
import com.halo.springcloud.domain.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author halo
 * @date 2021/6/30 13:50
 * @description
 */
@Slf4j
@RestController("orderController")
@RequestMapping(value = "/consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/getAll")
    public CommonResult<List<Payment>> getAllPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getAll",CommonResult.class);
    }
}
