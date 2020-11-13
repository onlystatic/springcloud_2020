package com.noonhope.springcloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noonhope.springcloud.dao.OrderDao;
import com.noonhope.springcloud.entity.Order;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:33
 */
@Slf4j
@Service
public class OrderService extends ServiceImpl<OrderDao, Order> {

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public boolean save(Order order) {

        log.info("===创建订单开始...");
        this.getBaseMapper().insert(order);
        log.info("===创建订单结束...");

        log.info("===扣减库存开始..");
        storageService.create(order.getProductId(), order.getCount());
        log.info("===扣减库存结束...");

        log.info("===扣减账户余额开始..");
        accountService.create(order.getUserId(), order.getAmount());
        log.info("===扣减账户余额结束...");
        return true;
    }
}
