package com.product.service;

import com.product.dto.ProductStockDTO;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-22 17:59
 **/
public interface ProductStockService {

    List<ProductStockDTO> queryByProductIds(Set<String> productIds);

}
