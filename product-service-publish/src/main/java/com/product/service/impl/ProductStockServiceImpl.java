package com.product.service.impl;

import com.product.dao.ProductStockDAO;
import com.product.dto.ProductStockDTO;
import com.product.entity.ProductStockEntity;
import com.product.service.ProductStockService;
import com.product.transformer.ProductStockTransformer;
import com.tan.kit.guava2.Lists2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-22 18:08
 **/
@Service("productStockService")
public class ProductStockServiceImpl implements ProductStockService {

    @Autowired
    private ProductStockDAO productStockDAO;

    @Override
    public List<ProductStockDTO> queryByProductIds(Set<String> productIds) {
        List<ProductStockEntity> productStockEntities = productStockDAO.queryByProductIds(productIds);
        if (CollectionUtils.isEmpty(productStockEntities)) {
            return Collections.emptyList();
        }
        return Lists2.transform(productStockEntities, ProductStockTransformer.ENTITY_TO_DTO);
    }
}
