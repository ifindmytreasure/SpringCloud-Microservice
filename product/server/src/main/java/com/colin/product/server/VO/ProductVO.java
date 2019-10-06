package com.colin.product.server.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:26
 * @desc:
 */
@Data
public class ProductVO {
    //类目名
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    private List<ProductInfoVO> productInfoList;

}
