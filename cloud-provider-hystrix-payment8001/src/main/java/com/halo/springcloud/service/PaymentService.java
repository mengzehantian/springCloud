package com.halo.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author halo
 * @date 2021/7/14 18:49
 * @description
 */
@Service
public class PaymentService {
    public String paymentInfo_Ok(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_Ok,id:"+id+"\t"+"哈哈~~~";
    }

    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_timeout,id:"+id+"\t"+"哈哈~~~"+" 耗时(秒):"+timeNumber;
    }
}
