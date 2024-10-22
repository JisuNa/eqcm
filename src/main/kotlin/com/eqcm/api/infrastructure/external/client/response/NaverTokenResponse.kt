package com.eqcm.api.infrastructure.external.client.response

import com.fasterxml.jackson.annotation.JsonProperty

class NaverTokenResponse(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("refresh_token")
    val refreshToken: String,
    @JsonProperty("token_type")
    val tokenType: String,
    @JsonProperty("expires_in")
    val expiresIn: Int
)
