package com.eqcm.api.infrastructure.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository: JpaRepository<ProductOptionRepository, Long> {
}
