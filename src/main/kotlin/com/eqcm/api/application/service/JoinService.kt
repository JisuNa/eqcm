package com.eqcm.api.application.service

import com.eqcm.api.application.exception.DuplicateEmailException
import com.eqcm.api.application.security.PasswordProvider
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.vo.TermsAgreement
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.entity.MemberAgreement
import com.eqcm.api.infrastructure.persistence.entity.MemberSocial
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
    private val memberSocialRepository: MemberSocialRepository,
    private val passwordProvider: PasswordProvider
) {
    @Transactional
    fun emailJoin(req: EmailJoinRequest) {
        checkEmail(req.joinInfo.email)
        val member = addMember(req)
        addMemberAgreement(member.id, req.termsAgreements)
    }

    private fun addMember(req: EmailJoinRequest): Member {
        val member = Member(
            email = req.joinInfo.email,
            password = passwordProvider.hash(req.password),
            name = req.joinInfo.name,
            gender = req.joinInfo.gender,
            birthday = req.joinInfo.birthday,
            phoneNumber = req.joinInfo.phoneNumber
        )
        return memberRepository.save(member)
    }

    @Transactional
    fun socialJoin(req: SocialJoinRequest) {
        checkEmail(req.joinInfo.email)
        val member = addMemberWithSocial(req)
        addMemberAgreement(member.id, req.termsAgreements)
    }

    private fun checkEmail(email: Email) {
        memberRepository.findByEmail(email)?.also { throw DuplicateEmailException() }
    }

    private fun addMemberWithSocial(req: SocialJoinRequest): Member {
        val savedMember = memberRepository.save(
            Member(
                email = req.joinInfo.email,
                name = req.joinInfo.name,
                gender = req.joinInfo.gender,
                birthday = req.joinInfo.birthday,
                phoneNumber = req.joinInfo.phoneNumber
            )
        )

        memberSocialRepository.save(
            MemberSocial(
                memberId = savedMember.id,
                providerType = req.socialProviderType,
                socialId = req.socialId
            )
        )

        return savedMember
    }

    private fun addMemberAgreement(memberId: Long, termsAgreements: List<TermsAgreement>) {
        val memberAgreements = termsAgreements.map {
            MemberAgreement(
                memberId = memberId,
                termsType = it.type,
                agreeYn = it.agreeYn
            )
        }
        memberAgreementRepository.saveAll(memberAgreements)
    }
}
