package com.product.transformer;

import com.product.dto.ProductStockDTO;
import com.product.entity.ProductStockEntity;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-22 19:39
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductStockTransformer extends BaseTransformer {

    public static final SafeFunction<ProductStockDTO, ProductStockEntity> DTO_TO_ENTITY = input -> convert(input, new ProductStockEntity());

    public static final SafeFunction<ProductStockEntity, ProductStockDTO> ENTITY_TO_DTO = input -> convert(input, new ProductStockDTO());


}
