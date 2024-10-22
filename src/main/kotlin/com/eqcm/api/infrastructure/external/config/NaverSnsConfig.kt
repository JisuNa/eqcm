package com.eqcm.api.infrastructure.external.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "social.client.naver")
class NaverSnsConfig(
    val clientId: String,
    val clientSecret: String,
    val redirectUri: String,
    val grantType: String
)
