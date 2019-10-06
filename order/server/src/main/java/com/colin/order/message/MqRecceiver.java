package com.colin.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: BlueMelancholy
 * 2019/10/6 18:31
 * @desc:
 */
@Component
@Slf4j
public class MqRecceiver {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue("myQueue"),
                    exchange = @Exchange("myExchange")
            )
    )
    public void process(String message){
        log.info("MqRecceiver: {}",message);
    }
}
