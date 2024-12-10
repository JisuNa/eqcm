package com.eqcm.api.presentation.controller

import com.eqcm.api.application.service.ProductService
import com.eqcm.api.presentation.common.response.SingleResponse
import com.eqcm.api.presentation.controller.response.ProductDetailResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {
    @GetMapping("/{productId}", name = "상품 상세 조회")
    fun getProductDetail(@PathVariable productId: Long): SingleResponse<ProductDetailResponse> {
        return SingleResponse(
            productService.getProductDetail(productId).let {
                ProductDetailResponse(
                    brand = it.brand,
                    category = it.category,
                    product = it.product,
                    shipping = ProductDetailResponse.Shipping(
                        estimatedTime = "3 days",
                        fee = 5000
                    )
                )
            }
        )
    }
}
