package com.noonhope.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @author onlystatic
 * @date 2020/10/28 18:37
 */
public interface ILoadBalancer {

    /**
     * xxx
     *
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);

}
