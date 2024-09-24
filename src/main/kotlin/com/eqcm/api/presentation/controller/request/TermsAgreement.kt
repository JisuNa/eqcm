package com.eqcm.api.presentation.controller.request

import com.eqcm.api.common.declaration.TermsType
import com.eqcm.api.common.declaration.Yn
import com.eqcm.api.infrastructure.persistence.entity.MemberAgreement

data class TermsAgreement(
    val type: TermsType,
    val agreeYn: Yn
) {
    fun toMemberAgreementEntity(memberId: Long) = MemberAgreement(
        memberId = memberId,
        termsType = type,
        agreeYn = agreeYn
    )
}
