package com.eqcm.api.application.service

import com.eqcm.api.application.exception.DuplicateEmailException
import com.eqcm.api.application.exception.NotFoundOtpException
import com.eqcm.api.application.exception.NotMatchedOtpException
import com.eqcm.api.application.security.PasswordProvider
import com.eqcm.api.domain.generator.OtpGenerator
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.value.PhoneNumber
import com.eqcm.api.domain.vo.TermsAgreementVo
import com.eqcm.api.infrastructure.cache.repository.OtpRepository
import com.eqcm.api.infrastructure.notification.SmsSender
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.entity.MemberAgreement
import com.eqcm.api.infrastructure.persistence.repository.MemberAgreementRepository
import com.eqcm.api.infrastructure.persistence.repository.MemberRepository
import com.eqcm.api.presentation.controller.request.EmailJoinRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(
    private val memberRepository: MemberRepository,
    private val memberAgreementRepository: MemberAgreementRepository,
    private val otpRepository: OtpRepository,
    private val passwordProvider: PasswordProvider,
    private val smsSender: SmsSender
) {
    @Transactional
    fun emailJoin(req: EmailJoinRequest) {
        checkEmail(req.joinInfoVo.email)
        val member = addMember(req)
        addMemberAgreement(member.id, req.termsAgreementVos)
    }

    private fun addMember(req: EmailJoinRequest): Member {
        val member = Member(
            email = req.joinInfoVo.email,
            password = passwordProvider.hash(req.password),
            name = req.joinInfoVo.name,
            gender = req.joinInfoVo.gender,
            birthday = req.joinInfoVo.birthday,
            phoneNumber = req.joinInfoVo.phoneNumber
        )
        return memberRepository.save(member)
    }

    private fun checkEmail(email: Email) {
        memberRepository.findByEmail(email)?.also { throw DuplicateEmailException() }
    }

    private fun addMemberAgreement(memberId: Long, termsAgreementVos: List<TermsAgreementVo>) {
        val memberAgreements = termsAgreementVos.map {
            MemberAgreement(
                memberId = memberId,
                termsType = it.type,
                agreeYn = it.agreeYn
            )
        }
        memberAgreementRepository.saveAll(memberAgreements)
    }

    fun sendOtpToPhone(phoneNumber: PhoneNumber): String {
        val otp = OtpGenerator.generate()
        otpRepository.save(phoneNumber, otp)
        smsSender.send(phoneNumber, otp)
        return otp
    }

    fun verifyOtp(phoneNumber: PhoneNumber, reqOtp: String) {
        val savedOtp = otpRepository.findByKey(phoneNumber) ?: throw NotFoundOtpException()
        if (savedOtp != reqOtp) {
            throw NotMatchedOtpException()
        }
    }
}
