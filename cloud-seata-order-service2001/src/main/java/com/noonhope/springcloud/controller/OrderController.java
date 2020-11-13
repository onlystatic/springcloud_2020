package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.entity.Order;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.OrderService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/12 11:11
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/commit")
    public CommonResult<Order> create() {
        Order order = new Order(1L, 1L, 10, BigDecimal.valueOf(100), 0);
        if (orderService.save(order, 0)) {
            return new CommonResult<>(200, "创建订单成功。", order);
        } else {
            return new CommonResult<>(200, "创建订单失败。", null);
        }
    }

    @GetMapping("/rollback")
    public CommonResult<Order> rollback() {
        Order order = new Order(1L, 1L, 10, BigDecimal.valueOf(100), 0);
        if (orderService.save(order, 1)) {
            return new CommonResult<>(200, "创建订单成功。", order);
        } else {
            return new CommonResult<>(200, "创建订单失败。", null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Order> create(@PathVariable("id") Integer id) {
        return new CommonResult<>(200, "查询成功。", orderService.getById(id));
    }

}
