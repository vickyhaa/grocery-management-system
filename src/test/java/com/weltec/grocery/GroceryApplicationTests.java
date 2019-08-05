package com.weltec.grocery;

import com.weltec.grocery.dao.IProductRepository;
import com.weltec.grocery.dao.IUserRepository;
import com.weltec.grocery.pojo.Product;
import com.weltec.grocery.pojo.User;

import org.junit.Assert;
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

    @Autowired
    IProductRepository productRepository;


    @Test
    public void test() {
        List<User> all = repository.findAll ();
        Assert.assertNotNull (all.get (0));
    }
    @Test
    public void productTest(){
        Product product = productRepository.findById ("1").get ();
        Assert.assertNotNull (product);
    }
    @Test
    public void userTest(){
        User u  = repository.findByEmail ("2");
        Assert.assertEquals ("liu",u.getUserName ());

    }

}
