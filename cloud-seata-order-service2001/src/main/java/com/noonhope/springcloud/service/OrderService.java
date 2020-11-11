package com.noonhope.springcloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noonhope.springcloud.dao.OrderDao;
import com.noonhope.springcloud.entity.Order;
import org.springframework.stereotype.Service;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:33
 */
@Service
public class OrderService extends ServiceImpl<OrderDao, Order> {


}
