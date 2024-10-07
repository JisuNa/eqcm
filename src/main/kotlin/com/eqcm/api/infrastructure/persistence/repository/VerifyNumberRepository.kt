package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.domain.value.PhoneNumber
import com.eqcm.api.infrastructure.persistence.entity.VerifyNumber
import org.springframework.data.jpa.repository.JpaRepository

interface VerifyNumberRepository: JpaRepository<VerifyNumber, Long> {
    fun findByPhoneNumber(phoneNumber: PhoneNumber): VerifyNumber?
}
