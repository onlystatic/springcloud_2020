package com.noonhope.springcloud.service.impl;

import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import com.noonhope.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author v_qianglong
 * @date 2020/11/10 13:16
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> getPaymentSql(Long id) {
        return new CommonResult<>(444, "服务降级返回---PaymentFallbackService", new Payment(id, "errorSerial..."));
    }
}
