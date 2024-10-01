package com.eqcm.api.application.security

import com.eqcm.api.domain.value.Email
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.xml.bind.DatatypeConverter
import java.util.Date
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtProvider(
    @Value("\${jwt.secret}")
    private val secret: String? = null
) {
    private val secretByte = DatatypeConverter.parseBase64Binary(secret)
    private val secretKey = Keys.hmacShaKeyFor(secretByte)

    fun accessToken(email: Email) = generate(email, ACCESS_TOKEN_EXPIRATION)

    fun refreshToken(email: Email) = generate(email, REFRESH_TOKEN_EXPIRATION)

    private fun generate(email: Email, expirationTime: Long): String {
        val now = Date()
        val validity = Date(now.time + expirationTime)

        return Jwts.builder()
            .subject(email.value)
            .issuedAt(now)
            .expiration(validity)
            .signWith(secretKey, Jwts.SIG.HS512)
            .compact()
    }

    companion object {
        // access 토큰 유효시간 1시간
        private const val ACCESS_TOKEN_EXPIRATION = 1000L * 60 * 60

        // refresh 토큰 유효시간 1주일
        private const val REFRESH_TOKEN_EXPIRATION = 1000L * 60 * 60 * 24 * 7
    }
}
