package com.halo.springcloud.controller;


import com.halo.springcloud.domain.CommonResult;
import com.halo.springcloud.domain.Payment;
import com.halo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author halo
 * @date 2021/6/30 10:23
 * @description
 */
@RestController("paymentController")
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/add")
    public CommonResult add(Payment payment){
        boolean result = paymentService.save(payment);
        log.info("*****插入结果是:"+result);
        if(result){
            return new CommonResult(200,"添加成功",result);
        }else {
            return new CommonResult(444,"添加成功",null);
        }
    }

    @GetMapping(value = "/getAll")
    public CommonResult<List<Payment>> queryAll(){
        List<Payment> list = paymentService.list(null);
        return new CommonResult<>(200,"查询结果",paymentService.list(null));
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        if(payment!=null){
            return new CommonResult<>(200,"查询成功",payment);
        }else {
            return new CommonResult<>(200,"没有对应记录，查询ID："+id,null);
        }
    }

}
