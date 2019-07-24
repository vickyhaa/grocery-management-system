package com.weltec.grocery.service;

import com.weltec.grocery.pojo.User;

import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:18
 */
public interface IUserService {
   List<User> findAll();
   void deleteUser(String id);
   void updateUser(User u);
   void createUser(User u);
   Boolean isLogin(User u);
   User findByEmail(String email);
   Boolean isUserExist(User u);



}
