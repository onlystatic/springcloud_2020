package com.noonhope.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author v_qianglong
 * @date 2020/11/10 11:23
 */
@RestController
public class CircleBreakerController {

    private static final String SERVICE_URL = "http://nacos-payment-provider";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate
                .getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 参数非法异常。");
        } else if (null == result.getData()) {
            throw new NullPointerException("NullPointerException, 空指针异常。");
        }

        return result;
    }

}
