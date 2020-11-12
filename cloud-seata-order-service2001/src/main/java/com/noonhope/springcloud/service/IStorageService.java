package com.noonhope.springcloud.service;

import com.noonhope.springcloud.entity.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author v_qianglong
 * @date 2020/11/12 12:53
 */
@FeignClient(value = "cloud-seata-storage-service")
public interface IStorageService {

    /**
     * 创建
     *
     * @param productId
     * @param count
     * @return
     */
    @GetMapping("/storage")
    CommonResult<String> create(@RequestParam("product_id") Long productId, @RequestParam("count") Integer count);
}
