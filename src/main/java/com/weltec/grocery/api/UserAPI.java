package com.weltec.grocery.api;

import com.weltec.grocery.VO.UserVo;
import com.weltec.grocery.pojo.User;
import com.weltec.grocery.service.IUserService;
import com.weltec.grocery.VO.ResponseVO;
import com.weltec.grocery.utils.KeyGenerator;
import com.weltec.grocery.utils.ResponseUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:27
 */
@RestController
public class UserAPI {

    @Autowired
    IUserService userService;

    @PostMapping("/api/login")
    public ResponseVO login(@RequestBody User u){
        System.out.println (u);
        try{
            if(userService.isLogin (u))
                return ResponseUtils.success ();
        }catch(Exception e){
            return  ResponseUtils.error (404,e.getMessage ());
        }
        return ResponseUtils.success ();
    }

    @PostMapping("/api/register")
    public ResponseVO register(@RequestBody User u){
        
        try{
            boolean isExist = userService.isUserExist (u);
            User newUser=new User();
          
            if(isExist){
                BeanUtils.copyProperties (u,newUser);

                newUser.setUserId (KeyGenerator.genUniqueKey ());
                userService.createUser (newUser);
                return ResponseUtils.success ();
            }

        }catch(Exception e) {
            return ResponseUtils.error (404, e.getMessage ());
        }
        return ResponseUtils.success ();
    }

    @GetMapping("/api/find")
    public ResponseVO findAll(){
        List<User> all = userService.findAll ();
        return ResponseUtils.success (all);

    }
    @GetMapping("/api/findUser/{email}")
    public ResponseVO findUser(@PathVariable("email") String email){
        User u = userService.findByEmail (email);

        UserVo newUser= new UserVo ();
        BeanUtils.copyProperties (u,newUser);

        return ResponseUtils.success (newUser);
    }
}
