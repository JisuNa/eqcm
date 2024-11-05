package com.eqcm.api.presentation.controller.response

import com.eqcm.api.domain.vo.BrandVo
import com.eqcm.api.domain.vo.CategoryVo
import com.eqcm.api.domain.vo.ProductVo


class ProductDetailResponse(
    val brand: BrandVo,
    val category: CategoryVo,
    val product: ProductVo,
    val shipping: Shipping
) {
    class Shipping(
        val estimatedTime: String,
        val fee: Int
    )
}
