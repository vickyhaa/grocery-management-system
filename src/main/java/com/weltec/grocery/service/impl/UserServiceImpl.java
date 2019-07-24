package com.weltec.grocery.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.weltec.grocery.dao.IUserRepository;
import com.weltec.grocery.pojo.User;
import com.weltec.grocery.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:22
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll ();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById (id);
    }

    @Override
    public void updateUser(User u) {
        User user = userRepository.findById (u.getUserId ()).get ();
        BeanUtils.copyProperties (u,user);
        userRepository.save (user);
    }

    @Override
    public void createUser(User u) {
        userRepository.save (u);
    }

    @Override
    public Boolean isLogin(User u) {

        User user = userRepository.findByEmail (u.getEmail ());
        if(user==null) throw new RuntimeException ("Email Not Exist..");
        System.out.println (u.getPassword ()+"      "+user.getPassword ());
        if(!u.getPassword ().equals (user.getPassword ())) throw new RuntimeException ("Password Not Correct..");
        return true;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail (email);
    }


    @Override
    public Boolean isUserExist(User u) {
        User user = userRepository.findByEmail (u.getEmail ());
        if(user!=null) {
            throw new RuntimeException ("Email Exist..");
        }else {
            return true;
        }
    }
}
