package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.value.Email
import jakarta.validation.constraints.NotNull

data class EmailLoginRequest(
    val email: Email,
    @field:NotNull
    val password: String
)
