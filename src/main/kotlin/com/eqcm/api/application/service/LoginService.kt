package com.eqcm.api.application.service

import com.eqcm.api.application.exception.NotAllowEmailLoginException
import com.eqcm.api.application.exception.NotFoundPasswordException
import com.eqcm.api.application.exception.UnauthorizedException
import com.eqcm.api.application.security.JwtProvider
import com.eqcm.api.application.security.PasswordProvider
import com.eqcm.api.domain.declaration.JwtType
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.vo.AuthTokenDto
import com.eqcm.api.infrastructure.external.client.NaverSnsClient
import com.eqcm.api.infrastructure.external.config.NaverSnsConfig
import com.eqcm.api.infrastructure.persistence.entity.Member
import com.eqcm.api.infrastructure.persistence.repository.MemberRepository
import com.eqcm.api.infrastructure.persistence.repository.MemberSocialRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val memberRepository: MemberRepository,
    private val memberSocialRepository: MemberSocialRepository,
    private val jwtProvider: JwtProvider,
    private val passwordProvider: PasswordProvider,
    private val naverSnsClient: NaverSnsClient,
    private val naverSnsConfig: NaverSnsConfig
) {
    fun emailLogin(email: Email, password: String): AuthTokenDto {
        val member = getMemberWithEmail(email)

        val memberPassword = member.password ?: memberSocialRepository.findById(member.id).getOrNull()
            ?.let { throw NotAllowEmailLoginException() }
        ?: throw NotFoundPasswordException()

        if (!passwordProvider.matches(password, memberPassword)) {
            throw UnauthorizedException()
        }

        return getAuthToken(email)
    }

    private fun getMemberWithEmail(email: Email): Member {
        return memberRepository.findByEmail(email) ?: throw UnauthorizedException()
    }

    private fun getAuthToken(email: Email): AuthTokenDto {
        val accessToken = jwtProvider.generate(email, JwtType.ACCESS)
        val refreshToken = jwtProvider.generate(email, JwtType.REFRESH)

        return AuthTokenDto(accessToken, refreshToken)
    }

    fun naverLogin(code: String, state: String): AuthTokenDto {
        return naverSnsClient.getToken(
            grantType = naverSnsConfig.grantType,
            clientId = naverSnsConfig.clientId,
            clientSecret = naverSnsConfig.clientSecret,
            code = code,
            state = state
        ).let {
            AuthTokenDto(it.accessToken, it.refreshToken)
        }
    }
}
