package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import com.noonhope.springcloud.service.PaymentService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author onlystatic
 * @date 2020-10-17 09:05 PM
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping
    public CommonResult create(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        log.info("*****插入结果：" + result);
        if (result) {
            return new CommonResult(200, "创建成功。serverPort:" + serverPort, payment.getId());
        }
        return new CommonResult(444, "创建失败。");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        if (null != payment) {
            return new CommonResult(200, "查询成功。serverPort:" + serverPort, payment);
        }
        return new CommonResult(200, "查询失败，查询id：" + id);
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******element:" + service);
        }
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            log.info(serviceInstance.getServiceId() + "-> " + serviceInstance.getHost() + ":"
                    + serviceInstance.getPort() + "-> " + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String getFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
