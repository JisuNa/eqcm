package com.eqcm.api.domain.vo

data class AuthToken(
    val accessToken: String,
    val refreshToken: String
)
