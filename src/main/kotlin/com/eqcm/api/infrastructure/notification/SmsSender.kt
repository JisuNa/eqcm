package com.eqcm.api.infrastructure.notification

import com.eqcm.api.domain.value.PhoneNumber
import org.springframework.stereotype.Component

@Component
interface SmsSender {
    fun send(phoneNumber: PhoneNumber, message: String)
}
