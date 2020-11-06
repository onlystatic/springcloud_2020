package com.noonhope.springcloud.controller;

import com.noonhope.springcloud.service.IMessageProvider;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_qianglong
 * @date 2020/11/6 13:22
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send_message")
    public String sendMessage() {
        return messageProvider.send();
    }
}
