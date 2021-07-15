package com.halo.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){

        //int timeNumber = 10/0;
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_timeout,id:"+id+"\t"+"哈哈~~~"+" 耗时(秒):"+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池:"+Thread.currentThread().getName()+"系统繁忙或者运行报错,id:"+id+"\t"+"哈哈~~~"+" 耗时(秒):"+"服务降级处理";
    }

}
