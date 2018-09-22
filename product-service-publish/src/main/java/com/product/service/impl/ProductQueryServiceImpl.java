package com.product.service.impl;

import com.google.common.collect.Lists;
import com.product.dao.ProductDAO;
import com.product.dto.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.param.ProductQueryParam;
import com.product.service.ProductQueryService;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.dto.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<ProductDTO> productDTOs = Lists.newArrayList();
        for (ProductEntity productEntity : productEntities) {
            ProductDTO productDTO = BaseTransformer.convert(productEntity, new ProductDTO());
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public PageModel<ProductDTO> queryParam(ProductQueryParam queryParam) {
        List<ProductEntity> productEntities = productDAO.queryByParam(queryParam);
        List<ProductDTO> productDTOs = Lists.newArrayList();
        for (ProductEntity productEntity : productEntities) {
            ProductDTO productDTO = BaseTransformer.convert(productEntity, new ProductDTO());
            productDTOs.add(productDTO);
        }
        int count = productDAO.count(queryParam);
        return PageModel.build(productDTOs, count);
    }
}
