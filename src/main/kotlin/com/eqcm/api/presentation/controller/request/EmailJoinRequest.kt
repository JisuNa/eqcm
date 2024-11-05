package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.vo.JoinInfoVo
import com.eqcm.api.domain.vo.TermsAgreementVo

data class EmailJoinRequest(
    val joinInfoVo: JoinInfoVo,
    val termsAgreementVos: List<TermsAgreementVo>,
    val password: String
)
