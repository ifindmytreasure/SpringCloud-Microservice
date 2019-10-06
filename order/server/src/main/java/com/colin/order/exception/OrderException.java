package com.colin.order.exception;

import com.colin.order.enums.ResultEnum;

/**
 * @author: BlueMelancholy
 * 2019/10/2 18:29
 * @desc:
 */
public class OrderException extends RuntimeException{
    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    public OrderException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
    }
}
