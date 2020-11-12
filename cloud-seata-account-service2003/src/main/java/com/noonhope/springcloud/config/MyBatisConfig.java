package com.noonhope.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author v_qianglong
 * @date 2020/11/12 13:48
 */
@Configuration
@MapperScan({"com.noonhope.springcloud.dao"})
public class MyBatisConfig {

}
