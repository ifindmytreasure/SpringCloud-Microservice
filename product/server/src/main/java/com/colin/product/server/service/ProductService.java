package com.colin.product.server.service;


import com.colin.product.common.DecreaseStockInput;
import com.colin.product.common.ProductInfoOutput;
import com.colin.product.server.domain.ProductInfo;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:08
 * @desc:
 */
public interface ProductService {
    /**
     * 查询所有上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    List<ProductInfoOutput> getAllByProductIdList(List<String> productIdList);

    /**
     * 根据订单id和下单数量扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
