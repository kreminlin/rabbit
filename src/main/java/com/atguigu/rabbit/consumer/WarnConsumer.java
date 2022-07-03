package com.atguigu.rabbit.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.atguigu.rabbit.config.ConfirmConfig;
import org.springframework.stereotype.Component;

/**
 * 报警消费者
 */
@Component
@Slf4j
public class WarnConsumer {

    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE_NAME)
    public void receiveWarningMsg(Message message) {
        String msg = new String(message.getBody());
        log.error("报警发现不可路由消息：{}", msg);
    }

}
