package com.noonhope.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noonhope.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:27
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {

}
