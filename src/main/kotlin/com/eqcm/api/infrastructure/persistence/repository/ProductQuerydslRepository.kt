package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.Product

interface ProductQuerydslRepository {
    fun findProductItems(productId: Long): Product?
}
