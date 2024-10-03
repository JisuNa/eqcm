package com.eqcm.api.application.service

import com.eqcm.api.application.exception.NotFoundMemberSocialException
import com.eqcm.api.application.exception.UnauthorizedException
import com.eqcm.api.application.security.JwtProvider
import com.eqcm.api.domain.declaration.JwtType
import com.eqcm.api.domain.declaration.SocialProviderType
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.vo.AuthToken
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.entity.MemberSocial
import com.eqcm.api.infrastructure.persistence.repository.MemberRepository
import com.eqcm.api.infrastructure.persistence.repository.MemberSocialRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val memberRepository: MemberRepository,
    private val memberSocialRepository: MemberSocialRepository,
    private val jwtProvider: JwtProvider
) {
    fun emailLogin(email: Email, password: String): AuthToken {
        getMemberWithEmail(email).also {
            if (it.password != password) throw UnauthorizedException()
        }

        return getAuthToken(email)
    }

    private fun getMemberWithEmail(email: Email): Member {
        return memberRepository.findByEmail(email) ?: throw UnauthorizedException()
    }

    fun socialLogin(email: Email, type: SocialProviderType, socialId: String): AuthToken {
        val member = getMemberWithEmail(email)
        checkMemberSocial(member.id, type, socialId)

        return getAuthToken(email)
    }

    private fun checkMemberSocial(memberId: Long, type: SocialProviderType, socialId: String): MemberSocial {
        return memberSocialRepository.findById(memberId).getOrNull()
            ?.also {
                if (it.providerType != type || it.socialId != socialId) {
                    throw NotFoundMemberSocialException()
                }
            } ?: throw NotFoundMemberSocialException()
    }

    private fun getAuthToken(email: Email): AuthToken {
        val accessToken = jwtProvider.generate(email, JwtType.ACCESS)
        val refreshToken = jwtProvider.generate(email, JwtType.REFRESH)

        return AuthToken(accessToken, refreshToken)
    }
}
