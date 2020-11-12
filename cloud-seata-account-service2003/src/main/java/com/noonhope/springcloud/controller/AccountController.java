package com.noonhope.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noonhope.springcloud.entity.Account;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.AccountService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:43
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/account")
    public CommonResult<String> create(@RequestParam("user_id") Long userId,
            @RequestParam("amount") BigDecimal amount) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getUserId, userId);
        Account accountExist = accountService.getById(queryWrapper);
        BigDecimal used = accountExist.getUsed().subtract(amount);
        BigDecimal residue = accountExist.getTotal().subtract(used);
        Account account = new Account(userId, accountExist.getTotal(), used, residue);
        boolean result = accountService.save(account);
        if (result) {
            return new CommonResult<>(200, "保存成功。", null);
        } else {
            return new CommonResult<>(200, "保存失败。", null);
        }
    }

    @GetMapping("/account/{user_id}")
    public CommonResult<Account> getById(@PathVariable("user_id") Long userId) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getUserId, userId);
        return new CommonResult<>(accountService.getOne(queryWrapper));
    }
}
