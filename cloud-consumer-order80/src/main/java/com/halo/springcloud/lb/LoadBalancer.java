package com.halo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *  自定义 负载均衡接口
 * @author halo
 */
public interface LoadBalancer {

    /**
     * 负载均衡接口，返回执行调用的服务对象
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
