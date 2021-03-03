package com.noonhope.springcloud.service;

import com.noonhope.springcloud.entity.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author onlystatic
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
    @PostMapping(value = "/storage/decrease")
    CommonResult<String> decrease(@RequestParam("product_id") Long productId, @RequestParam("count") Integer count);
}
