package com.weltec.grocery.dao;

import com.weltec.grocery.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:38
 */
public interface IProductRepository  extends JpaRepository<Product,String > {
    Product findByProductName(String name);
}
