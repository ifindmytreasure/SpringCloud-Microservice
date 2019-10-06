package com.colin.order.message;

import com.colin.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author: BlueMelancholy
 * 2019/10/6 18:53
 * @desc:
 */
@Component
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {
//    @StreamListener("myOutputChannel")
//    public void process(Object message){
//        log.info("StreamReceiver: {}", message);
//    }
    @StreamListener("myOutputChannel")
    public void process(OrderDTO message){
        log.info("StreamReceiver: {}", message);
    }
}
