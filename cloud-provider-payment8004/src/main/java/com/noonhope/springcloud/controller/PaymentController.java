package com.noonhope.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author onlystatic
 * @date 2020-10-24 01:24 PM
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * @return
     */
    @GetMapping("zk/payment")
    public String paymentZk() {
        return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
