package com.eqcm.api.presentation.controller.request

import com.eqcm.api.common.declaration.Gender
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.presentation.controller.configuration.annotation.EmailFormat
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern

import org.springframework.format.annotation.DateTimeFormat

data class JoinRequest(
    @field:EmailFormat
    val email: String,
    @field:NotNull
    val name: String,
    @field:NotNull
    val gender: Gender,
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val birthday: String,
    @field:Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "휴대폰 번호 양식으로 입력해주세요.")
    val phoneNumber: String
) {
    fun toMemberEntity() = Member(
        email = email,
        name = name,
        gender = gender,
        birthday = birthday,
        phoneNumber = phoneNumber
    )
}
