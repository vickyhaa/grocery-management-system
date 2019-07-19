package com.weltec.grocery.service.impl;

import com.weltec.grocery.dao.IProductRepository;
import com.weltec.grocery.pojo.Product;
import com.weltec.grocery.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:54
 */
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll ();
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById (id).get ();
    }

    @Override
    public void createProduct(Product p) {
        productRepository.save (p);
    }

    @Override
    public void updateProduct(Product p) {
        Product product = productRepository.findById (p.getProductId ()).get ();
        BeanUtils.copyProperties (p,product);
        productRepository.save (product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById (id);
    }
}
