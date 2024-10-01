package com.eqcm.api.infrastructure.persistence.entity

import com.eqcm.api.domain.declaration.Gender
import com.eqcm.api.domain.value.Birthday
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.value.PhoneNumber
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate

@Entity
class Member(
    val email: Email,
    var password: String? = null,
    var name: String,
    var gender: Gender,
    val birthday: Birthday,
    var phoneNumber: PhoneNumber
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @CreatedDate
    val createdDtm: LocalDateTime = LocalDateTime.now()
    var updatedDtm: LocalDateTime = LocalDateTime.now()
}
