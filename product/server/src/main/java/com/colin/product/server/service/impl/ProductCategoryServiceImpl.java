package com.colin.product.server.service.impl;

import com.colin.product.server.domain.ProductCategory;
import com.colin.product.server.repository.ProductCategoryRepository;
import com.colin.product.server.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:21
 * @desc:
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
