package com.noonhope.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author v_qianglong
 * @date 2020/10/29 20:02
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentOk(Integer id) {
        return "PaymentFallbackServiceImpl ---> paymentOk fallback...";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "PaymentFallbackServiceImpl ---> paymentTimeout fallback...";
    }
}
