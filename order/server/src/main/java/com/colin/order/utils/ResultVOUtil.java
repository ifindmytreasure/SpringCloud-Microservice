package com.colin.order.utils;

import com.colin.order.VO.ResultVO;

/**
 * @author: BlueMelancholy
 * 2019/10/2 18:55
 * @desc:
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
