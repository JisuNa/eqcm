package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.value.PhoneNumber

data class OtpVerifyRequest(
    val phoneNumber: PhoneNumber,
    val otp: String
)
