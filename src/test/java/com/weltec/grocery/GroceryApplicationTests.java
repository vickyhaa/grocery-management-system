package com.weltec.grocery;

import com.weltec.grocery.dao.IUserRepository;
import com.weltec.grocery.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroceryApplicationTests {

    @Autowired
    IUserRepository repository;

    @Test
    public void contextLoads() {
        List<User> all = repository.findAll ();
        //System.out.println (all.get (0)+"dddddddddddddddddd");
    }

}
