package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.Category

interface CategoryQuerydslRepository {
    fun findCategoryById(id: Long): Category?
}
