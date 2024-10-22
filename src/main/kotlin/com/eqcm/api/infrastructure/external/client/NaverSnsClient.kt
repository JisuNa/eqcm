package com.eqcm.api.infrastructure.external.client

import com.eqcm.api.infrastructure.external.client.response.NaverTokenResponse
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange

interface NaverSnsClient {
    @GetExchange(url = "/token")
    fun getToken(
        @RequestParam("grant_type") grantType: String,
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String,
        @RequestParam("state") state: String
    ): NaverTokenResponse
}
