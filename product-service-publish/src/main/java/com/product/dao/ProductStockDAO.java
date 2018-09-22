package com.product.dao;

import com.product.entity.ProductStockEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-22 18:07
 **/
public interface ProductStockDAO {


    @Select({"<script>",
            "SELECT stock_count",
             "FROM product_stock",
             "WHERE status=1 AND product_id IN",
            "<foreach item='id' collection='productIds' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
            })
    List<ProductStockEntity> queryByProductIds(@Param("productIds") Set<String> productIds);

}
