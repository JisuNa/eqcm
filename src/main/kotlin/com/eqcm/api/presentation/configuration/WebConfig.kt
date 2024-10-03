package com.eqcm.api.presentation.controller.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping(ALLOWED_MAPPING)
            .allowedOrigins(ALLOWED_ORIGINS)
            .allowedHeaders(ALLOWED_HEADERS)
            .allowedMethods(ALLOWED_METHODS)
    }

    companion object {
        const val ALLOWED_MAPPING = "/**"
        const val ALLOWED_METHODS = "POST, PUT, GET, DELETE, OPTIONS"
        const val ALLOWED_ORIGINS = "http://localhost:3000"
        const val ALLOWED_HEADERS = "*"
    }
}
