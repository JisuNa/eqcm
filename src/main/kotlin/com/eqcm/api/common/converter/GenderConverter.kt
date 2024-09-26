package com.eqcm.api.common.converter

import com.eqcm.api.domain.declaration.Gender
import jakarta.persistence.Converter

@Converter(autoApply = true)
class GenderConverter : AbstractBaseEnumConverter<Gender>(Gender::class.java)
