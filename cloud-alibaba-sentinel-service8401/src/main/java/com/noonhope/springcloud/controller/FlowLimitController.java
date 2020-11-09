package com.noonhope.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/test_hot_key")
    @SentinelResource(value = "test_test_hot_key", blockHandler = "testHotKeyHandler")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p1", required = false) String p2) {
        //int age = 10 / 0;
        return "testHotKey...";
    }

    public String testHotKeyHandler(String p1, String p2, BlockException blockException) {
        return "testHotKeyHandler...";
    }
}
