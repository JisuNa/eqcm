package com.eqcm.api.domain.declaration

enum class JwtType(
    val expiration: Long,
    val description: String
) {
    ACCESS(3_600_000, "1시간"),
    REFRESH(604_800_000, "7일")
}
