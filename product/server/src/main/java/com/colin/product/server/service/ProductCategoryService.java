package com.colin.product.server.service;

import com.colin.product.server.domain.ProductCategory;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:19
 * @desc:
 */
public interface ProductCategoryService {
    /**
     * 根据类目类型查询商品类别
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> getByCategoryTypeIn(List<Integer> categoryTypeList);
}
