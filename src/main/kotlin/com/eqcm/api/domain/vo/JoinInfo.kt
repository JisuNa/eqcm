package com.eqcm.api.domain.vo

import com.eqcm.api.domain.declaration.Gender
import com.eqcm.api.domain.value.Birthday
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.value.PhoneNumber
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.presentation.configuration.annotation.EmailFormat
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.time.LocalDate

import org.springframework.format.annotation.DateTimeFormat

data class JoinInfo(
    val email: Email,
    val name: String,
    val gender: Gender,
    val birthday: Birthday,
    val phoneNumber: PhoneNumber
) {
    fun toMemberEntity() = Member(
        email = email,
        name = name,
        gender = gender,
        birthday = birthday,
        phoneNumber = phoneNumber
    )
}
