package com.halo.springcloud.controller;


import com.halo.springcloud.domain.Payment;
import com.halo.springcloud.service.PaymentService;
import com.halo.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    /**
     * 服务发现discovery
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/add")
    public CommonResult add(@RequestBody Payment payment){
        boolean result = paymentService.save(payment);
        log.info("*****插入结果是:"+result);
        if(result){
            return new CommonResult(200,"添加成功,serverPort:"+serverPort,result);
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
            log.info("查询到的结果是:"+payment);
            return new CommonResult<>(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult<>(200,"没有对应记录，查询ID："+id,null);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            log.info("我们获取到的微服务的信息"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
