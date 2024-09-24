package com.eqcm.api.presentation.controller.request

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
    val gender: String,
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val birthday: String,
    @field:Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "휴대폰 번호 양식으로 입력해주세요.")
    val phoneNumber: String
)
