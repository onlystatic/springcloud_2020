package com.noonhope.springcloud.service;

import com.noonhope.springcloud.entity.common.CommonResult;
import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author onlystatic
 * @date 2020/11/12 11:17
 */
@FeignClient(value = "cloud-seata-account-service")
public interface IAccountService {

    /**
     * 创建
     *
     * @param userId
     * @param amount
     * @param rollback
     * @return
     */
    @PostMapping("/account/decrease")
    CommonResult<String> decrease(@RequestParam("user_id") Long userId, @RequestParam("amount") BigDecimal amount,
            @RequestParam("rollback") Integer rollback);
}
