package com.eqcm.api.common.converter

import com.eqcm.api.domain.declaration.SocialProviderType
import jakarta.persistence.Converter

@Converter(autoApply = true)
class SocialProviderTypeConverter : AbstractBaseEnumConverter<SocialProviderType>(SocialProviderType::class.java)
