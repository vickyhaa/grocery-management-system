package com.weltec.grocery.service;

import com.weltec.grocery.pojo.Product;

import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:52
 */
public interface IProductService {
    List<Product> findAll();
    Product findProductById(String id);
    void createProduct(Product p);
    void updateProduct(Product p);
    void deleteProductById(String id);
    Product findByName(Product p);
    Boolean isProductExist(String name);

}
