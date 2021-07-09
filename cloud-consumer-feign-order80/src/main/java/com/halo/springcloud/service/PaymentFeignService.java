package com.halo.springcloud.service;

import com.halo.springcloud.domain.Payment;
import com.halo.springcloud.util.CommonResult;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author halo
 * @date 2021/7/9 18:43
 * @description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //指定调用服务名称
public interface PaymentFeignService {

    /**
     * @GetMapping(value = "/payment/get/{id}") 指定调用方法路径
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById3(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();


}
