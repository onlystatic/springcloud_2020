package com.noonhope.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.entity.payment.Payment;
import com.noonhope.springcloud.service.PaymentService;
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

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback", fallback = "fallbackHandler")
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "fallbackHandler", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
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

    /**
     * fallback处理方法
     *
     * @param id
     * @param throwable
     * @return
     */
    public CommonResult<Payment> fallbackHandler(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常，fallbackHandler：" + throwable.getMessage(), payment);
    }

    /**
     * blockHandler
     *
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "Sentinel限流，无此流水，blockHandler：" + blockException.getMessage(), payment);
    }

    @GetMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentService.getPaymentSql(id);
    }
}
