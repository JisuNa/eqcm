package com.eqcm.api.infrastructure.notification

import com.eqcm.api.domain.value.PhoneNumber
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class SmsSender {
    fun send(phoneNumber: PhoneNumber, message: String) {
        // fake sms sending
    }
}
