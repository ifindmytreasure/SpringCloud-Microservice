package com.colin.order.service;

import com.colin.order.dto.OrderDTO;

/**
 * @author: BlueMelancholy
 * 2019/10/2 17:59
 * @desc:
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);

    /**
     * 只有卖家能访问
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
