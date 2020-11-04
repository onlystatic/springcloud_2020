package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import com.noonhope.springcloud.service.PaymentFeignService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author onlystatic
 * @date 2020/10/28 19:41
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping("/feign/timeout")
    public String getTimeout() {
        return paymentFeignService.getFeignTimeout();
    }
}
