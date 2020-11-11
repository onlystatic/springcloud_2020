package com.noonhope.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:27
 */
@Setter
@Getter
@TableName("t_storage")
public class Storage {

    private Integer id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;


}
