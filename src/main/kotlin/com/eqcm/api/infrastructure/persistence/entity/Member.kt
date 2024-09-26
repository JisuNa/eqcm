package com.eqcm.api.infrastructure.persistence.entity

import com.eqcm.api.common.declaration.Gender
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate

@Entity
class Member(
    val email: String,
    var password: String? = null,
    var name: String,
    var gender: Gender,
    val birthday: LocalDate,
    var phoneNumber: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @CreatedDate
    val createdDtm: LocalDateTime = LocalDateTime.now()
    var updatedDtm: LocalDateTime = LocalDateTime.now()
}