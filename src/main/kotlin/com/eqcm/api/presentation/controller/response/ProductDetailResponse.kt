package com.eqcm.api.presentation.controller.response

class ProductDetailResponse(
    val brand: Brand,
    val category: Category,
    val product: Product,
    val shipping: Shipping
) {
    class Brand(
        val id: Long,
        val name: String,
        val subCopy: String,
        val logoUrl: String
    )

    class Category(
        val id: Long,
        val name: String,
        val subCategory: Category?
    )

    class Product(
        val id: Long,
        val name: String,
        val image: String,
        val isLike: Boolean,
        val avgReviewPoint: Double,
        val reviewCount: Int,
        val sale: Sale,
        val option: Option
    ) {
        class Sale(
            val cost: Int,
            val discountRate: Int,
            val discountPrice: Int
        )

        class Option(
            val size: List<String>,
            val color: List<String>
        )
    }

    class Shipping(
        val estimatedTime: String,
        val fee: Int
    )
}
