package com.eqcm.api.common.converter

import com.eqcm.api.domain.declaration.SnsType
import jakarta.persistence.Converter

@Converter(autoApply = true)
class SocialProviderTypeConverter : AbstractBaseEnumConverter<SnsType>(SnsType::class.java)
