package com.eqcm.api.domain.generator

class OtpGenerator {
    companion object {
        fun generate() = (1000..9999).random().toString()
    }
}
