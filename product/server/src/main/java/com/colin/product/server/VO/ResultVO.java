package com.colin.product.server.VO;

import lombok.Data;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:25
 * @desc:http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
