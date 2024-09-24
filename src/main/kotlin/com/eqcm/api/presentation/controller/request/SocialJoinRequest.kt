package com.eqcm.api.presentation.controller.request

import com.eqcm.api.common.declaration.SocialProviderType
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.entity.MemberSocial
import jakarta.validation.constraints.NotNull

class SocialJoinRequest(
    val joinRequest: JoinRequest,
    val termsAgreement: TermsAgreement,
    val socialProviderType: SocialProviderType,
    @field:NotNull
    val socialId: String,
) {
    fun toMemberEntity() = Member(
        email = joinRequest.email,
        name = joinRequest.name,
        gender = joinRequest.gender,
        birthday = joinRequest.birthday,
        phoneNumber = joinRequest.phoneNumber
    )

    fun toMemberAgreementEntity(memberId: Long) = termsAgreement.toMemberAgreementEntity(memberId)

    fun toMemberSocialEntity(memberId: Long) = MemberSocial(
        memberId = memberId,
        providerType = socialProviderType,
        socialId = socialId
    )
}
