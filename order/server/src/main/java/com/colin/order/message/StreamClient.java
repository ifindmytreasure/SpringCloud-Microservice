package com.colin.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: BlueMelancholy
 * 2019/10/6 18:47
 * @desc:
 */
public interface StreamClient {
    @Input("myInputChannel")
    SubscribableChannel input();
    @Output("myOutputChannel")
    MessageChannel output();
}
