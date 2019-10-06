package com.colin.product.server.repository;

import com.colin.product.server.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/2 13:54
 * @desc:
 */
@Repository
public interface ProductInfoRepository  extends JpaRepository<ProductInfo,String> {
    /**
     * 获取在架的商品信息
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 根据id获取商品
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
