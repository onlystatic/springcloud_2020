package com.noonhope.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.noonhope.springcloud.service.PaymentHystrixService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author onlystatic
 * @date 2020-10-28 11:56 PM
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment/hystrix")
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    @HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        return paymentHystrixService.paymentTimeout(id);
    }

    public String paymentTimeoutFallback(Integer id) {
        return "这里是Timeout消费80，请求支付服务超时或者程序异常，请稍后重试。\t" + id;
    }

    public String paymentGlobalFallback() {
        return "这里是Global消费80，请求支付服务超时或者程序异常，请稍后重试。";
    }
}
