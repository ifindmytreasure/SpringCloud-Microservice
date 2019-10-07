package com.colin.order.message;

import com.colin.order.utils.JsonUtil;
import com.colin.product.common.ProductInfoOutput;
import com.fasterxml.jackson.core.type.TypeReference;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/7 10:30
 * @desc:
 */
@Component
@Slf4j
public class ProductInfoReceiver {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";
    @RabbitListener(
            queuesToDeclare = @Queue("productInfo")
    )
    public void process(String message){
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息：{}", "productInfo", productInfoOutputList);
        assert productInfoOutputList != null;
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            redisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId())
                    ,String.valueOf(productInfoOutput.getProductStock()) );
        }
    }
}
