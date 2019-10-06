package com.colin.product.server.exceptions;


import com.colin.product.server.enums.ResultEnum;

/**
 * @author: BlueMelancholy
 * 2019/10/3 16:12
 * @desc:
 */
public class ProductException extends RuntimeException{
    private Integer code;

    public ProductException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
