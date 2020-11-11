package com.noonhope.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noonhope.springcloud.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:27
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}
