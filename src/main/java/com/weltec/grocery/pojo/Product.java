package com.weltec.grocery.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Description:
 * Author: Liu
 * Date: 2019-07-19 19:28
 */
@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    private String productId;
    private String productName;
    private Integer product_amount;
    private Double price;
    private String description;
    private Double cost;
    private String product_img;
    private String create_time;
    private String update_time;

}
