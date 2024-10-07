package com.eqcm.api.infrastructure.persistence.entity

import com.eqcm.api.domain.value.PhoneNumber
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class VerifyNumber(
    val phoneNumber: PhoneNumber,
    var number: String,
    var expiredDtm: LocalDateTime
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    fun isMatched(number: String) = this.number == number

    fun isExpired() = expiredDtm.isBefore(LocalDateTime.now())
}
