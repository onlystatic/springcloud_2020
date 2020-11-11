package com.noonhope.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:27
 */
@Setter
@Getter
@TableName("t_order")
public class Order {

    private Integer id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;
    /**
     * 状态：0未支付，1已支付
     */
    private Integer status;

}
