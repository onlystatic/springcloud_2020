package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.entity.Order;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.OrderService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/12 11:11
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order")
    public CommonResult<Order> create(@RequestParam("user_id") Long userId,
            @RequestParam("product_id") Long productId,
            @RequestParam("count") Integer count,
            @RequestParam("amount") BigDecimal amount) {
        Order order = new Order(userId, productId, count, amount, 0);
        if (orderService.save(order)) {
            return new CommonResult<>(200, "创建订单成功。", order);
        } else {
            return new CommonResult<>(200, "创建订单失败。", null);
        }
    }

    @GetMapping("/order/{id}")
    public CommonResult<Order> create(@PathVariable("id") Integer id) {
        return new CommonResult<>(200, "查询成功。", orderService.getById(id));
    }

}
