package com.noonhope.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noonhope.springcloud.entity.Account;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.AccountService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:43
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping()
    public CommonResult<Account> create(@RequestBody Account storage) {
        boolean result = accountService.save(storage);
        if (result) {
            return new CommonResult<>(200, "保存成功。", storage);
        } else {
            return new CommonResult<>(200, "保存失败。", null);
        }
    }

    @GetMapping("/{user_id}")
    public CommonResult<Account> getById(@PathVariable("user_id") Long userId) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getUsed, userId);
        return new CommonResult<>(accountService.getOne(queryWrapper));
    }
}
