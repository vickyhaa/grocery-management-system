package com.weltec.grocery.VO;

import lombok.Data;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-21 22:05
 */
@Data
public class UserVo {
    private String userId;
    private String userName;
    private String FirstName;
    private String lastName;
    private String email;
    private String address;
    private Integer type;
}
