package com.halo.springcolud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author halo
 * @date 2021/7/14 19:29
 * @description
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("payment/hystrix/ok/{id}")
    public String payment_Ok(@PathVariable("id") Integer id);


    @GetMapping("payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
