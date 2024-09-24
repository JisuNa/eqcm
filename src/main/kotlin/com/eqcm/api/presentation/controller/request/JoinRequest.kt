package com.eqcm.api.presentation.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import org.springframework.format.annotation.DateTimeFormat

data class JoinRequest(
    @Email
    val email: String,
    @field:NotNull
    val name: String,
    @field:NotNull
    val gender: String,
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val birthday: String,
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.")
    val phoneNumber: String
)
