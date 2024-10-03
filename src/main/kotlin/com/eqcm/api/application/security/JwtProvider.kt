package com.eqcm.api.application.security

import com.eqcm.api.domain.declaration.JwtType
import com.eqcm.api.domain.value.Email
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.util.Date
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtProvider(
    @Value("\${jwt.secret}")
    private val secret: String
) {
    private val secretByte = secret.toByteArray(Charsets.UTF_8)
    private val secretKey = Keys.hmacShaKeyFor(secretByte)

    fun generate(email: Email, jwtType: JwtType): String {
        val now = Date()
        val validity = Date(now.time + jwtType.expiration)

        return Jwts.builder()
            .subject(email.value)
            .issuedAt(now)
            .expiration(validity)
            .signWith(secretKey, Jwts.SIG.HS512)
            .compact()
    }
}
