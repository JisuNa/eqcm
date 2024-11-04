package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.ItemStock
import org.springframework.data.jpa.repository.JpaRepository

interface ItemStockRepository : JpaRepository<ItemStock, Long>
