package com.weltec.grocery.dao;

import com.weltec.grocery.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 18:59
 */
public interface IUserRepository  extends JpaRepository<User,String> {
   User findByEmail(String email);
}
