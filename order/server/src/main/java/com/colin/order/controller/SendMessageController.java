package com.colin.order.controller;
import java.math.BigDecimal;

import com.colin.order.dto.OrderDTO;
import com.colin.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

/**
 * @author: BlueMelancholy
 * 2019/10/6 18:55
 * @desc:
 */
@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;
//    @GetMapping("/sendMessage")
//    public void process(){
//        streamClient.output().send(MessageBuilder.withPayload("now" + new Date()).build());
//    }
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("241413");
        orderDTO.setBuyerName("Colin");
        orderDTO.setBuyerPhone("4131231");
        orderDTO.setBuyerAddress("江苏");
        orderDTO.setBuyerOpenid("1231");
        orderDTO.setOrderAmount(new BigDecimal("20"));
        orderDTO.setOrderStatus(0);
        orderDTO.setPayStatus(0);
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
