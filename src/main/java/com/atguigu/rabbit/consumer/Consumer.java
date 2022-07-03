package com.atguigu.rabbit.consumer;

import com.atguigu.rabbit.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收消息
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveMessage(Message message) {
        String mesg = new String(message.getBody());
        System.out.println(mesg);
        log.info("接收到的消息: {}", mesg);
    }

}
