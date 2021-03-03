package com.noonhope.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author onlystatic
 * @date 2020/11/11 11:27
 */
@Setter
@Getter
@TableName("t_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("product_id")
    private Long productId;

    private Integer count;

    private BigDecimal amount;
    /**
     * 状态：0未支付，1已支付
     */
    private Integer status;

    public Order(Long userId, Long productId, Integer count, BigDecimal amount, Integer status) {
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.amount = amount;
        this.status = status;
    }
}
