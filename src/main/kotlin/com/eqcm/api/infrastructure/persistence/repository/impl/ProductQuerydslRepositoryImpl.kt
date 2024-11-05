package com.eqcm.api.infrastructure.persistence.repository.impl

import com.eqcm.api.infrastructure.persistence.entity.Product
import com.eqcm.api.infrastructure.persistence.entity.QItem.Companion.item
import com.eqcm.api.infrastructure.persistence.entity.QProduct.Companion.product
import com.eqcm.api.infrastructure.persistence.entity.QProductOption.Companion.productOption
import com.eqcm.api.infrastructure.persistence.entity.QProductOptionGroup.Companion.productOptionGroup
import com.eqcm.api.infrastructure.persistence.repository.ProductQuerydslRepository
import com.querydsl.jpa.impl.JPAQueryFactory

class ProductQuerydslRepositoryImpl(private val queryFactory: JPAQueryFactory) : ProductQuerydslRepository {
    override fun findProductItems(productId: Long): Product? {
        return queryFactory
            .selectFrom(product)
            .join(product.items, item).fetchJoin()
            .join(item.productOption, productOption).fetchJoin()
            .where(
                product.id.eq(productId)
            )
            .fetchOne()
    }
}
