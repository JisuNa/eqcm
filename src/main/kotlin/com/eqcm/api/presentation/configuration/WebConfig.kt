package com.eqcm.api.presentation.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping(ALLOWED_MAPPING)
            .allowedOrigins(*ALLOWED_ORIGINS.split(", ").toTypedArray())
            .allowedHeaders(*ALLOWED_HEADERS.split(", ").toTypedArray())
            .allowedMethods(*ALLOWED_METHODS)
            .allowCredentials(true)
            .maxAge(3600)
    }

    companion object {
        const val ALLOWED_MAPPING = "/**"
        val ALLOWED_METHODS = arrayOf("POST", "PUT", "GET", "DELETE", "OPTIONS")
        const val ALLOWED_ORIGINS = "http://localhost:3000"
        const val ALLOWED_HEADERS = "Origin, X-Requested-With, Content-Type, Accept, Authorization"
    }
}
