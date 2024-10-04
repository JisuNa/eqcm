package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.declaration.SocialProviderType
import com.eqcm.api.domain.vo.JoinInfo
import com.eqcm.api.domain.vo.TermsAgreement
import jakarta.validation.constraints.NotNull

class SocialJoinRequest(
    val joinInfo: JoinInfo,
    val termsAgreements: List<TermsAgreement>,
    val socialProviderType: SocialProviderType,
    @field:NotNull
    val socialId: String,
)
