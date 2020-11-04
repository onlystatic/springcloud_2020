package com.noonhope.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noonhope.springcloud.entity.payment.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author onlystatic
 * @date 2020-10-17 08:31 PM
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}
