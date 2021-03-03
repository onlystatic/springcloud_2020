package com.noonhope.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noonhope.springcloud.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author onlystatic
 * @date 2020/11/11 11:27
 */
@Mapper
public interface StorageDao extends BaseMapper<Storage> {

}
