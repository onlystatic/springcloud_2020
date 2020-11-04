package com.noonhope.springcloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noonhope.springcloud.dao.PaymentDao;
import com.noonhope.springcloud.entity.payment.Payment;
import org.springframework.stereotype.Service;

/**
 * @author onlystatic
 * @date 2020-10-17 08:51 PM
 */
@Service
public class PaymentService extends ServiceImpl<PaymentDao, Payment> {

}
