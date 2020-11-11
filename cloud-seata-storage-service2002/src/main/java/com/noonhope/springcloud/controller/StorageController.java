package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.entity.Storage;
import com.noonhope.springcloud.entity.common.CommonResult;
import com.noonhope.springcloud.service.StorageService;
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
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping()
    public CommonResult<Storage> create(@RequestBody Storage storage) {
        boolean result = storageService.save(storage);
        if (result) {
            return new CommonResult<>(200, "保存成功。", storage);
        } else {
            return new CommonResult<>(200, "保存失败。", null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Storage> getById(@PathVariable("id") Long id) {
        return new CommonResult<>(storageService.getById(id));
    }
}
