package com.eqcm.api.domain.vo

import com.eqcm.api.domain.declaration.Gender
import com.eqcm.api.domain.value.Birthday
import com.eqcm.api.domain.value.Email
import com.eqcm.api.domain.value.PhoneNumber

class JoinInfoVo(
    val email: Email,
    val name: String,
    val gender: Gender,
    val birthday: Birthday,
    val phoneNumber: PhoneNumber
)
