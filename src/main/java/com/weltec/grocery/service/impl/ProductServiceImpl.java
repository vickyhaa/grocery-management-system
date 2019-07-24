package com.weltec.grocery.service.impl;

import com.weltec.grocery.dao.IProductRepository;
import com.weltec.grocery.pojo.Product;
import com.weltec.grocery.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:54
 */
@Service
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

    @Override
    public Product findByName(Product p) {
        return productRepository.findByProductName (p.getProductName ());
    }

    @Override
    public Boolean isProductExist(String name) {
        Product p = productRepository.findByProductName (name);
        if(p==null) return true;
        throw new RuntimeException ("Product is Exist..");
    }
}
