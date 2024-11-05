package com.eqcm.api.infrastructure.persistence.repository.impl

import com.eqcm.api.infrastructure.persistence.entity.Category
import com.eqcm.api.infrastructure.persistence.entity.QCategory.Companion.category
import com.eqcm.api.infrastructure.persistence.repository.CategoryQuerydslRepository
import com.querydsl.jpa.impl.JPAQueryFactory

class CategoryQuerydslRepositoryImpl(private val queryFactory: JPAQueryFactory) : CategoryQuerydslRepository {
    override fun findCategoryById(id: Long): Category? {
        return queryFactory
            .selectFrom(category)
            .fetchOne()
    }
}
