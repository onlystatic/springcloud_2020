package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/10 11:02
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(1L, new Payment(1L, UUID.randomUUID().toString()));
        paymentMap.put(2L, new Payment(2L, UUID.randomUUID().toString()));
        paymentMap.put(3L, new Payment(3L, UUID.randomUUID().toString()));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> getPaymentSql(@PathVariable("id") Long id) {
        Payment payment = paymentMap.get(id);
        return new CommonResult(200, "操作成功，端口号：" + serverPort, payment);
    }
}
