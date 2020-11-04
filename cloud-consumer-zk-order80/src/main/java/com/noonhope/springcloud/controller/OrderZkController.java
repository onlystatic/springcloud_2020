package com.noonhope.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author onlystatic
 * @date 2020-10-24 05:15 PM
 */
@Slf4j
@RestController
public class OrderZkController {

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk/test")
    public String test() {
        return "Hello...";
    }

    @GetMapping("/consumer/zk/payment")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/zk/payment", String.class);
    }
}
