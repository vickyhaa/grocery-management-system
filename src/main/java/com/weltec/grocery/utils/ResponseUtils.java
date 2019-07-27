package com.weltec.grocery.utils;

import com.weltec.grocery.VO.ResponseVO;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 20:08
 */
public class ResponseUtils {
    public static ResponseVO success(Object object) {
        ResponseVO resultVO = new ResponseVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success..");
        return resultVO;
    }

    public static ResponseVO success() {
        return success(null);
    }

    public static ResponseVO error(Integer code, String msg) {
        ResponseVO resultVO = new ResponseVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData (null);
        return resultVO;
    }
}
