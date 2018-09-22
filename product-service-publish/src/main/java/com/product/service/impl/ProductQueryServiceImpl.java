package com.product.service.impl;

import com.product.dao.ProductDAO;
import com.product.dto.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.param.ProductQueryParam;
import com.product.service.ProductQueryService;
import com.product.transformer.ProductTransformers;
import com.tan.kit.dto.PageModel;
import com.tan.kit.guava2.Lists2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 21:12
 **/
@Service("productQueryService")
public class ProductQueryServiceImpl implements ProductQueryService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> queryProductByIds(Set<String> productIds) {
        List<ProductEntity> productEntities = productDAO.queryByIds(productIds);
        if (CollectionUtils.isEmpty(productEntities)) {
            return Collections.EMPTY_LIST;
        }
       return Lists2.transform(productEntities, ProductTransformers.ENTITY_TO_DTO);
    }

    @Override
    public PageModel<ProductDTO> queryParam(ProductQueryParam queryParam) {
        List<ProductEntity> productEntities = productDAO.queryByParam(queryParam);
        List<ProductDTO> productDTOs = Lists2.transform(productEntities, ProductTransformers.ENTITY_TO_DTO);
        int count = productDAO.count(queryParam);
        return PageModel.build(productDTOs, count);
    }
}
