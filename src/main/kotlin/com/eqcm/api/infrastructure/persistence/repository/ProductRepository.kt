package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>, ProductQuerydslRepository
