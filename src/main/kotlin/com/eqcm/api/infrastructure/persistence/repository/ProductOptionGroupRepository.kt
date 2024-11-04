package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.ProductOptionGroup
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionGroupRepository : JpaRepository<ProductOptionGroup, Long> {
}
