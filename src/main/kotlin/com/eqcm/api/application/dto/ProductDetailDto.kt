package com.eqcm.api.application.dto

import com.eqcm.api.domain.vo.BrandVo
import com.eqcm.api.domain.vo.CategoryVo
import com.eqcm.api.domain.vo.ProductVo

class ProductDetailDto(
    val product: ProductVo,
    val brand: BrandVo,
    val category: CategoryVo
)
