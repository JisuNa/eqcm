package com.eqcm.api.application.service

import com.eqcm.api.application.exception.DuplicateEmailException
import com.eqcm.api.domain.value.Email
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.entity.MemberAgreement
import com.eqcm.api.infrastructure.persistence.repository.MemberAgreementRepository
import com.eqcm.api.infrastructure.persistence.repository.MemberRepository
import com.eqcm.api.infrastructure.persistence.repository.MemberSocialRepository
import com.eqcm.api.presentation.controller.request.EmailJoinRequest
import com.eqcm.api.presentation.controller.request.SocialJoinRequest

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(
    private val memberRepository: MemberRepository,
    private val memberAgreementRepository: MemberAgreementRepository,
    private val memberSocialRepository: MemberSocialRepository
) {
    @Transactional
    fun emailJoin(req: EmailJoinRequest) {
        checkEmail(req.joinInfo.email)
        val member = addMember(req.toMemberEntity())
        addMemberAgreement(req.toMemberAgreementEntity(member.id))
    }

    @Transactional
    fun socialJoin(request: SocialJoinRequest) {
        val member = addMember(request.toMemberEntity())
        addMemberAgreement(request.toMemberAgreementEntity(member.id))
        memberSocialRepository.save(request.toMemberSocialEntity(member.id))
    }

    private fun checkEmail(email: Email) {
        memberRepository.findByEmail(email.value)?.also { throw DuplicateEmailException() }
    }

    private fun addMember(member: Member): Member {
        return memberRepository.save(member)
    }

    private fun addMemberAgreement(memberAgreement: List<MemberAgreement>) {
        memberAgreementRepository.saveAll(memberAgreement)
    }
}
