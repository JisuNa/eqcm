package com.eqcm.api.domain.generator

import java.security.SecureRandom

class OtpGenerator {
    companion object {
        private val secureRandom = SecureRandom()
        fun generate(length: Int = 4): String {
            require(length > 0) { "Length must be greater than 0" }
            return (1..length)
                .map { secureRandom.nextInt(0, 10) }
                .joinToString("")
        }
    }
}
