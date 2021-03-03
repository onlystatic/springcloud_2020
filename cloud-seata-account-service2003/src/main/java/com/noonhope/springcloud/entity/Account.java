package com.noonhope.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author onlystatic
 * @date 2020/11/11 11:27
 */
@Setter
@Getter
@TableName("t_account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @JsonProperty("user_id")
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
