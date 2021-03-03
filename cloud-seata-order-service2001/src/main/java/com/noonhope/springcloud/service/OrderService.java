package com.noonhope.springcloud.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noonhope.springcloud.dao.OrderDao;
import com.noonhope.springcloud.entity.Order;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author onlystatic
 * @date 2020/11/11 11:33
 */
@Slf4j
@Service
public class OrderService extends ServiceImpl<OrderDao, Order> {

    @Resource
    private IAccountService accountService;

    @Resource
    private IStorageService storageService;

    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public boolean save(Order order, Integer rollback) {

        log.info("===创建订单开始...");
        this.save(order);
        log.info("===创建订单结束...");

        log.info("===扣减库存开始..");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("===扣减库存结束...");

        log.info("===扣减账户余额开始..");
        accountService.decrease(order.getUserId(), order.getAmount(), rollback);
        log.info("===扣减账户余额结束...");

        log.info("===更新订单状态开始..");
        order.setStatus(1);
        this.updateById(order);
        log.info("===更新订单状态结束...");
        return true;
    }
}
