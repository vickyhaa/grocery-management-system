package com.weltec.grocery.api;

import com.weltec.grocery.VO.ResponseVO;
import com.weltec.grocery.pojo.Product;
import com.weltec.grocery.service.IProductService;
import com.weltec.grocery.utils.KeyGenerator;
import com.weltec.grocery.utils.ResponseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.SoundbankResource;
import java.util.List;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:28
 */
@RestController
public class ProductAPI {

    @Autowired
    IProductService productService;

    @GetMapping("/api/list")
    public ResponseVO findAll(){
        List<Product> all = productService.findAll ();
        return ResponseUtils.success (all);
    }

    @PostMapping("/api/saveProduct")
    public ResponseVO saveProduct(@RequestBody  Product p){
      
       try{
           if(productService.isProductExist (p.getProductName ())){
               Product newProduct = new Product ();
               BeanUtils.copyProperties (p,newProduct);
               newProduct.setUpdate_time (p.getCreate_time ());
               newProduct.setProductId (KeyGenerator.genUniqueKey ());
               productService.createProduct (newProduct);
               return ResponseUtils.success ();
           }
       }catch(Exception e){
            return ResponseUtils.error (400,e.getMessage ());
       }
        return ResponseUtils.success ();
    }
    @PutMapping("/api/update/{productId}")
    public ResponseVO update(@PathVariable("productId") String Id, @RequestBody Product p){

        Product product = productService.findProductById (Id);
        p.setCreate_time (product.getCreate_time ());
        BeanUtils.copyProperties (p,product);

        productService.createProduct (product);
        return ResponseUtils.success ();
    }
    @DeleteMapping("/api/deleteProduct/{productId}")
    public ResponseVO deleteProduct(@PathVariable("productId") String Id){

        productService.deleteProductById (Id);
        return ResponseUtils.success ();
    }
}
