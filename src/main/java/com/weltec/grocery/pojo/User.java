package com.weltec.grocery.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 18:46
 */
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    private String userId;
    private String userName;
    private String FirstName;
    private String lastName;
    private String email;
    private String address;
    private Integer type=0; //1 as admin 0 as user
    private String password;
    @Transient
    private String rePassword;

}
