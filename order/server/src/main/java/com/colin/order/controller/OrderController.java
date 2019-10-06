package com.colin.order.controller;

import com.colin.order.VO.ResultVO;
import com.colin.order.converter.OrderForm2OrderDTO;
import com.colin.order.dto.OrderDTO;
import com.colin.order.enums.ResultEnum;
import com.colin.order.exception.OrderException;
import com.colin.order.form.OrderForm;
import com.colin.order.service.OrderService;
import com.colin.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: BlueMelancholy
 * 2019/10/2 17:58
 * @desc:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 1.参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存(调用商品服务)
     * 5.订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> createOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确,orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDto = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.createOrder(orderDto);
        Map<String,String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

}
