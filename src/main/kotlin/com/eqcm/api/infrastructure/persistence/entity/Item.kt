package com.eqcm.api.infrastructure.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    val itemStocks: List<ItemStock> = listOf()
}
