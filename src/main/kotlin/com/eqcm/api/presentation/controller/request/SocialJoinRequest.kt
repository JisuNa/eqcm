package com.eqcm.api.presentation.controller.request

import com.eqcm.api.common.declaration.SocialProviderType
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.entity.MemberSocial
import jakarta.validation.constraints.NotNull

class SocialJoinRequest(
    val joinRequest: JoinRequest,
    val termsAgreements: List<TermsAgreement>,
    val socialProviderType: SocialProviderType,
    @field:NotNull
    val socialId: String,
) {
    fun toMemberEntity() = joinRequest.toMemberEntity()

    fun toMemberAgreementEntity(memberId: Long) = termsAgreements.map {
        it.toMemberAgreementEntity(memberId)
    }

    fun toMemberSocialEntity(memberId: Long) = MemberSocial(
        memberId = memberId,
        providerType = socialProviderType,
        socialId = socialId
    )
}
