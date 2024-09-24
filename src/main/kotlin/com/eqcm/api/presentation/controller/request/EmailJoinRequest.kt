package com.eqcm.api.presentation.controller.request

import com.eqcm.api.infrastructure.persistence.entity.Member
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

data class EmailJoinRequest(
    @field:Valid
    val joinRequest: JoinRequest,
    val termsAgreement: TermsAgreement,
    @field:NotNull
    val password: String
) {
    fun toMemberEntity() = Member(
        email = joinRequest.email,
        password = password,
        name = joinRequest.name,
        gender = joinRequest.gender,
        birthday = joinRequest.birthday,
        phoneNumber = joinRequest.phoneNumber
    )

    fun toMemberAgreementEntity(memberId: Long) = termsAgreement.toMemberAgreementEntity(memberId)
}
