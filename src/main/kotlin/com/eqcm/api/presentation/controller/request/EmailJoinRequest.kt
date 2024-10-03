package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.vo.JoinInfo
import com.eqcm.api.domain.vo.TermsAgreement

data class EmailJoinRequest(
    val joinInfo: JoinInfo,
    val termsAgreements: List<TermsAgreement>,
    val password: String
)
