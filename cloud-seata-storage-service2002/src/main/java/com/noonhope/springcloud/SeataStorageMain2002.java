package com.noonhope.springcloud;

import com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author v_qianglong
 * @date 2020/11/11 10:45
 */
@SpringBootApplication(exclude = GlobalTransactionAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002.class, args);
    }
}
