package com.halo.springcolud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

/**
 * @author halo
 * @date 2021/7/15 19:47
 * @description
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_Ok(Integer id) {
        return "------PaymentFallbackService fall back ---payment_Ok   ,~~~~~";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "------PaymentFallbackService fall back ---payment_timeout   ,~~~~~";
    }
}
