package com.halo.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.halo.springcloud.domain.Payment;
import com.halo.springcloud.mapper.PaymentMapper;
import com.halo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author halo
 * @date 2021/6/30 10:21
 * @description
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;
}
