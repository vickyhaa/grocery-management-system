package com.weltec.grocery.VO;

import lombok.Data;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 20:02
 */
@Data
public class ResponseVO<T> {
    private Integer code;
    private String msg;
    private T data;
}

