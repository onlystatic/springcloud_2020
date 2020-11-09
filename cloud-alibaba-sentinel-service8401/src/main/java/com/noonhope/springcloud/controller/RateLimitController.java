package com.noonhope.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/9 20:14
 */
@RestController
public class RateLimitController {

    @GetMapping("/by_resource")
    @SentinelResource(value = "by_resource", blockHandler = "byResourceHandler")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名访问OK.", new Payment(2020L, UUID.randomUUID().toString()));
    }

    public CommonResult byResourceHandler(BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getCanonicalName() + "\t 服务不可用。");
    }

    @GetMapping("/rate_limit/by_url")
    @SentinelResource(value = "by_url")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL访问OK.", new Payment(2020L, UUID.randomUUID().toString()));
    }
}
