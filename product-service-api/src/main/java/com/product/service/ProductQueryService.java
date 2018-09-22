package com.product.service;

import com.product.dto.ProductDTO;
import com.product.param.ProductQueryParam;
import com.tan.kit.dto.PageModel;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 20:50
 **/
public interface ProductQueryService {

    /**
     * 查询商品信息
     * @param productIds
     * @return
     */
    List<ProductDTO> queryProductByIds(Set<String> productIds);

    /**
     * 查询商品列表
     * @param queryParam
     * @return
     */
    PageModel<ProductDTO> queryParam(ProductQueryParam queryParam);
}
