package com.eqcm.api.application.service

import com.eqcm.api.application.dto.ProductDetailDto
import com.eqcm.api.application.exception.NotFoundProductException
import com.eqcm.api.domain.vo.BrandVo
import com.eqcm.api.domain.vo.CategoryVo
import com.eqcm.api.domain.vo.ProductVo
import com.eqcm.api.infrastructure.persistence.repository.ProductOptionGroupRepository
import com.eqcm.api.infrastructure.persistence.repository.ProductRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val optionGroupRepository: ProductOptionGroupRepository
) {
    @Transactional(readOnly = true)
    fun getProductDetail(productId: Long): ProductDetailDto {
        val product = getProduct(productId)
        val brand = getBrand(productId)
        val category = getCategory(productId)

        return ProductDetailDto(
            product = product,
            brand = brand,
            category = category,
        )
    }

    private fun getProduct(productId: Long): ProductVo {
        val productItems = productRepository.findProductItems(productId) ?: throw NotFoundProductException()

        val options = productItems.items.map { it.productOption }
        val optionGroupIds = options.map { it.productOptionGroup.id }.distinct()

        val optionGroups = optionGroupRepository.findByIds(optionGroupIds)

        return ProductVo(
            id = productItems.id,
            name = productItems.name,
            price = productItems.price,
            optionGroups = optionGroups.map { optionGroup ->
                ProductVo.OptionGroup(
                    id = optionGroup.id,
                    name = optionGroup.name,
                    options = optionGroup.productOptions.map { option ->
                        ProductVo.OptionGroup.Option(
                            id = option.id,
                            name = option.name
                        )
                    }
                )
            }
        )
    }

    private fun getBrand(productId: Long): BrandVo {
        return productRepository.findById(productId).getOrNull()
            ?.let {
                BrandVo(
                    id = it.brand.id,
                    name = it.brand.name,
                    subCopy = it.brand.subCopy,
                    logoUrl = null
                )
            }
            ?: throw NotFoundProductException()
    }

    private fun getCategory(productId: Long): CategoryVo {
        val category = productRepository.findById(productId).getOrNull()
            ?.category
            ?: throw NotFoundProductException()

        return CategoryVo(
            id = category.id,
            name = category.name
        )
    }
}
