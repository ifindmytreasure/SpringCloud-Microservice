package com.colin.product.server.utils;

import com.colin.product.server.VO.ProductVO;
import com.colin.product.server.VO.ResultVO;

/**
 * @author: BlueMelancholy
 * 2019/10/2 14:56
 * @desc:
 */
public class ResultVOUtil {
    public static ResultVO<ProductVO> success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData(data);
        return resultVO;
    }
}
