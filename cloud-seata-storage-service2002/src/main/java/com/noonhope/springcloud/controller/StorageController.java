package com.noonhope.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noonhope.springcloud.entity.Storage;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.StorageService;
import javax.annotation.Resource;
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
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/decrease")
    public CommonResult<String> decrease(@RequestParam("product_id") Long productId,
            @RequestParam("count") Integer count) {
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Storage::getProductId, productId);
        Storage storageExist = storageService.getOne(queryWrapper);
        Integer used = storageExist.getUsed() + count;
        Integer residue = storageExist.getTotal() - used;
        Storage storage = new Storage(storageExist.getId(), productId, storageExist.getTotal(), used, residue);
        boolean result = storageService.updateById(storage);
        if (result) {
            return new CommonResult<>(200, "保存成功。", null);
        } else {
            return new CommonResult<>(200, "保存失败。", null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Storage> getById(@PathVariable("id") Long id) {
        return new CommonResult<>(storageService.getById(id));
    }
}
