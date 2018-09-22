package com.product.transformer;

import com.product.dto.ProductDTO;
import com.product.entity.ProductEntity;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-22 19:54
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductTransformers extends BaseTransformer {

    public static final SafeFunction<ProductEntity, ProductDTO> ENTITY_TO_DTO = input-> convert(input, new ProductDTO());

    public static final SafeFunction<ProductDTO, ProductEntity>DTO_TO_ENTITY = input-> convert(input, new ProductEntity());
}
