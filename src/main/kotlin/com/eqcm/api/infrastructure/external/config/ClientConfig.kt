package com.eqcm.api.infrastructure.external.config

import com.eqcm.api.infrastructure.external.client.NaverSnsClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class ClientConfig {

    @Bean
    fun naverSnsClient(): NaverSnsClient {
        val restClient = RestClient.builder().baseUrl("https://nid.naver.com/oauth2.0").build()
        val build = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build()
        return build.createClient(NaverSnsClient::class.java)
    }
}
