package com.product.dao;

import com.product.entity.ProductEntity;
import com.product.param.ProductQueryParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 21:13
 **/
public interface ProductDAO {

    @Select({"<script>",
            "SELECT product_id, name, keyword, code, head_image, type, tag, status",
            "FROM product",
            "WHERE product_id IN",
            "<if test='type=0 and status=1'>",
            "<foreach item='id' collection='productIds' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</if>",
            "</script>"
    })
    List<ProductEntity> queryByIds(@Param("productIds") Set<String> productIds);


    @Select({"<script>",
            "SELECT name, keyword, code, type, tag, head_image, status",
            "weight, update_time",
            "FROM product",
            "WHERE status = 1 AND type = 0",
            "<if test='productCode!= null'>",
            "AND code LIKE CONCAT('%',#{productCode},'%')",
            "</if>",
            "<if test='productName!=null'>",
            "AND name LIKE CONCAT('%',#{productName},'%')",
            "</if>",
            "</script>"})
    List<ProductEntity> queryByParam(ProductQueryParam queryParam);

    @Select({"<script>",
            "SELECT count(1)",
            "FROM product",
            "WHERE status=1 AND type = 0",
            "<if test='productCode!= null'>",
            "AND code LIKE CONCAT('%',#{productCode},'%')",
            "</if>",
            "<if test='productName!=null'>",
            "AND name LIKE CONCAT('%',#{productName},'%')",
            "</if>",
            "</script>"})
    int count(ProductQueryParam queryParam);
}
