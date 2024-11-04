package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.ProductOptionGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductOptionGroupRepository : JpaRepository<ProductOptionGroup, Long> {
    @Query("""
        from ProductOptionGroup
        where id in :optionGroupIds
    """)
    fun findByIds(optionGroupIds: List<Long>): List<ProductOptionGroup>
}
