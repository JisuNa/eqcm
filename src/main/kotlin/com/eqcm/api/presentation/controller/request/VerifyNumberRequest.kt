package com.eqcm.api.presentation.controller.request

import com.eqcm.api.domain.value.PhoneNumber

data class VerifyNumberRequest(
    val phoneNumber: PhoneNumber,
    val checkNumber: String
)
