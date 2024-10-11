package com.eqcm.api.presentation.controller

import com.eqcm.api.presentation.controller.response.ProductDetailResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController {
    @GetMapping("/{productId}")
    fun getProductById(@PathVariable productId: Long): ProductDetailResponse {
        return ProductDetailResponse(
            brand = ProductDetailResponse.Brand(
                id = 1L,
                name = "드로우핏 우먼",
                subCopy = "드로우핏 우먼은 클래식을 현대적 감각으로 재해석하여 완성도 있는 뉴 컨템포러리 웨어를 추구합니다",
                logoUrl = "로고 URL"
            ),
            category = ProductDetailResponse.Category(
                id = 1L,
                name = "여성의류",
                subCategory = ProductDetailResponse.Category(
                    id = 2L,
                    name = "아우터",
                    subCategory = ProductDetailResponse.Category(
                        id = 3L,
                        name = "자켓",
                        subCategory = null
                    )
                )
            ),
            product = ProductDetailResponse.Product(
                id = 1L,
                name = "헤어리 알파카 울 칼라리스 자켓 [BEIGE]",
                image = "상품 이미지 URL",
                isLike = true,
                avgReviewPoint = 3.5,
                reviewCount = 3,
                sale = ProductDetailResponse.Product.Sale(
                    cost = 248000,
                    discountRate = 40,
                    discountPrice = 170624
                ),
                option = ProductDetailResponse.Product.Option(
                    size = listOf("S", "M"),
                    color = listOf("White", "Yellow", "Pink")
                )
            ),
            shipping = ProductDetailResponse.Shipping(
                estimatedTime = "3일 이내 출고",
                fee = 0
            )
        )
    }
}
