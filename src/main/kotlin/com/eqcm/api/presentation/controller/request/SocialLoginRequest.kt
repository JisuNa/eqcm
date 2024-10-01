package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.declaration.SocialProviderType
import com.eqcm.api.domain.value.Email
import jakarta.validation.constraints.NotNull

data class SocialLoginRequest(
    val email: Email,
    val socialProviderType: SocialProviderType,
    @field:NotNull
    val socialId: String
)
