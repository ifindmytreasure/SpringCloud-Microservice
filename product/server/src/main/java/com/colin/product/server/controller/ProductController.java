package com.colin.product.server.controller;


import com.colin.product.common.DecreaseStockInput;
import com.colin.product.common.ProductInfoOutput;
import com.colin.product.server.VO.ProductInfoVO;
import com.colin.product.server.domain.ProductCategory;
import com.colin.product.server.VO.ProductVO;
import com.colin.product.server.VO.ResultVO;
import com.colin.product.server.domain.ProductInfo;
import com.colin.product.server.service.ProductCategoryService;
import com.colin.product.server.service.ProductService;
import com.colin.product.server.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: BlueMelancholy
 * 2019/10/2 13:15
 * @desc:
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 查询所有在架商品
     * 获取类目type列表
     * 封装数据
     * @return
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.getByCategoryTypeIn(categoryTypeList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryId());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表信息供订单使用
     * @param productIdList
     * @return
     */
    @PostMapping("/listfororder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){
        return productService.getAllByProductIdList(productIdList);
    }
    @PostMapping("/decreasestock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }
}
