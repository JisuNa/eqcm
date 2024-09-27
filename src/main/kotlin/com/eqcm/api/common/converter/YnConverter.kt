package com.eqcm.api.common.converter

import com.eqcm.api.domain.declaration.Yn
import jakarta.persistence.Converter

@Converter(autoApply = true)
class YnConverter : AbstractBaseEnumConverter<Yn>(Yn::class.java)