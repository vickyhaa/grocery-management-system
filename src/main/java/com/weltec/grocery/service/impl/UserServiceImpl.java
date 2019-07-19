package com.weltec.grocery.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.weltec.grocery.dao.IUserRepository;
import com.weltec.grocery.pojo.User;
import com.weltec.grocery.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:22
 */
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
}
