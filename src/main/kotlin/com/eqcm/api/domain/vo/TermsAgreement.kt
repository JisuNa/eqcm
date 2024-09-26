package com.eqcm.api.domain.vo

import com.eqcm.api.domain.declaration.TermsType
import com.eqcm.api.domain.declaration.Yn
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
