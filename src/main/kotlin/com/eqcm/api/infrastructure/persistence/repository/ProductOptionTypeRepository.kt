package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.ProductOptionType
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionTypeRepository: JpaRepository<ProductOptionType, Long> {
}
