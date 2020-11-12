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
@TableName("t_account")
public class Account {

    private Integer id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;

    public Account(Long userId, BigDecimal total, BigDecimal used, BigDecimal residue) {
        this.userId = userId;
        this.total = total;
        this.used = used;
        this.residue = residue;
    }
}
