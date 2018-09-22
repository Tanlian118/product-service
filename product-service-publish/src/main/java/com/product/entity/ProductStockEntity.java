package com.product.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-22 18:01
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductStockEntity {

    /**
     * 库存id
     */
    Integer productStockId;

    /**
     * 商品id
     */
    String productId;

    /**
     * 库存数量
     */
    Integer stockCount;

    /**
     *状态：-1/0/1 -> 删除/禁用/正常
     */
    Integer status;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 更新时间
     */
    Date updateTime;

}
