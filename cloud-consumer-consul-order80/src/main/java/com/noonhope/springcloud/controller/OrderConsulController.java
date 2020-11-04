package com.noonhope.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author onlystatic
 * @date 2020-10-24 10:49 PM
 */
@RestController
@Slf4j
public class OrderConsulController {

    private static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul/payment")
    public String getPaymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/consul/payment", String.class);
    }

}
