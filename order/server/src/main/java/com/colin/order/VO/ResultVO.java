package com.colin.order.VO;

import lombok.Data;

/**
 * @author: BlueMelancholy
 * 2019/10/2 18:54
 * @desc:
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
