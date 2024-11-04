package com.eqcm.api.infrastructure.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class ProductOptionGroup(
    val name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productOptionGroup")
    val productOptions: List<ProductOption> = listOf()
}
