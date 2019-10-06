package com.colin.order.enums;

import lombok.Getter;

/**
 * @author: BlueMelancholy
 * 2019/10/2 17:48
 * @desc:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
