package com.colin.order.entity;

import com.colin.order.repository.OrderDetailRepository;
import com.colin.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author: BlueMelancholy
 * 2019/10/2 17:54
 * @desc:
 */
@Component
public class OrderDetailTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void testInsert(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("1234567");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal("3.5"));
        orderDetail.setProductQuantity(4);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        System.out.println(result);
    }
}