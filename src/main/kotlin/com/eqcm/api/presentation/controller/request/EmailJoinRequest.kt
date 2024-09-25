package com.eqcm.api.presentation.controller.request

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

data class EmailJoinRequest(
    @field:Valid
    val joinRequest: JoinRequest,
    val termsAgreements: List<TermsAgreement>,
    @field:NotNull
    val password: String
) {
    fun toMemberEntity() = joinRequest.toMemberEntity()

    fun toMemberAgreementEntity(memberId: Long) = termsAgreements.map {
        it.toMemberAgreementEntity(memberId)
    }
}
