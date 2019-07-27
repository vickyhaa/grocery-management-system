package com.weltec.grocery;

import com.weltec.grocery.dao.IProductRepository;
import com.weltec.grocery.dao.IUserRepository;
import com.weltec.grocery.pojo.Product;
import com.weltec.grocery.pojo.User;
<<<<<<< HEAD
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
=======
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 7f48572f1c28d70002315095f7f6c0e4acd7be7f
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

<<<<<<< HEAD
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
=======
    @Test
    public void contextLoads() {
        List<User> all = repository.findAll ();
        System.out.println (all.get (0)+"dddddddddddddddddd");
    }
    @Test
    public void productTest(){
        Product product = productRepository.findById ("1").get ();
        System.out.println (product);
    }
    @Test
    public void userTest(){
        User u  = repository.findByEmail ("2");
        System.out.println (u +"ffffffffff");
>>>>>>> 7f48572f1c28d70002315095f7f6c0e4acd7be7f
    }

}
