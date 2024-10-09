package com.eqcm.api.infrastructure.cache.repository

import com.eqcm.api.domain.value.PhoneNumber
import java.util.concurrent.TimeUnit
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class OtpRepository(private val redisTemplate: RedisTemplate<String, String>) {
    fun save(phoneNumber: PhoneNumber, otp: String) {
        redisTemplate.opsForValue().set(OTP_KEY + phoneNumber.value, otp, OTP_EXPIRE_MINUTES, TimeUnit.MINUTES)
    }

    fun findByKey(phoneNumber: PhoneNumber): String? {
        return redisTemplate.opsForValue().get(OTP_KEY + phoneNumber.value)
    }

    companion object {
        const val OTP_KEY = "JOIN:OTP:"
        const val OTP_EXPIRE_MINUTES = 1L
    }
}
