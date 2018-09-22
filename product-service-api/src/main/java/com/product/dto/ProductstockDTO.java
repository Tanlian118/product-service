package com.product.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author Tanlian
 * @create 2018-09-22 18:00
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductStockDTO implements Serializable {

    /**
     * 商品id
     */
    String productId;

    /**
     * 库存数量
     */
    Integer stockCount;

    /**
     * 状态：-1/0/1 -> 删除/禁用/正常
     */
    Integer status;
}
