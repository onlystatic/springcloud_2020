package com.noonhope.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/9 13:08
 */
@RestController
public class FlowLimitController {

    @GetMapping("/test_a")
    public String testA() {
        return "-----------testA";
    }

    @GetMapping("/test_b")
    public String testB() {
        return "-----------testB";
    }
}
