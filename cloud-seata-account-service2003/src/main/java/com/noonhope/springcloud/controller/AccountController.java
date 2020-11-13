package com.noonhope.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noonhope.springcloud.entity.Account;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.AccountService;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/11 11:43
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/decrease")
    public CommonResult<String> decrease(@RequestParam("user_id") Long userId,
            @RequestParam("amount") BigDecimal amount, @RequestParam("rollback") Integer rollback) {
        if (rollback != null && rollback == 1) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                log.error("程序异常，请稍后重试。{}", e.getMessage());
            }
        }
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getUserId, userId);
        Account accountExist = accountService.getOne(queryWrapper);
        BigDecimal used = accountExist.getUsed().add(amount);
        BigDecimal residue = accountExist.getTotal().subtract(used);
        Account account = new Account(accountExist.getId(), userId, accountExist.getTotal(), used, residue);
        boolean result = accountService.updateById(account);
        if (result) {
            return new CommonResult<>(200, "保存成功。", null);
        } else {
            return new CommonResult<>(200, "保存失败。", null);
        }
    }

    @GetMapping("/{user_id}")
    public CommonResult<Account> getById(@PathVariable("user_id") Long userId) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Account::getUserId, userId);
        return new CommonResult<>(accountService.getOne(queryWrapper));
    }
}
