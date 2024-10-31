package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.ProductInventory
import org.springframework.data.jpa.repository.JpaRepository

interface ProductInventoryRepository: JpaRepository<ProductInventory, Long> {
}
