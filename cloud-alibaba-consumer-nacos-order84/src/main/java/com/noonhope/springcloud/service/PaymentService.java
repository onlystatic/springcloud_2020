package com.noonhope.springcloud.service;

import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import com.noonhope.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author v_qianglong
 * @date 2020/11/10 13:15
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    /**
     * getPaymentSql
     *
     * @param id
     * @return
     */
    @GetMapping("/paymentSql/{id}")
    CommonResult<Payment> getPaymentSql(@PathVariable("id") Long id);
}
