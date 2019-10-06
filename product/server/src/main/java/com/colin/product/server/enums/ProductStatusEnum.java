package com.colin.product.server.enums;

import lombok.Getter;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:11
 * @desc:
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架");
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
