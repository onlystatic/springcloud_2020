package com.noonhope.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author v_qianglong
 * @date 2020/11/10 10:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentNacosMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosMain9003.class, args);
    }
}
