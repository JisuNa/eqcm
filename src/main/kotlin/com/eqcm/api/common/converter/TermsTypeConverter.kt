package com.eqcm.api.common.converter

import com.eqcm.api.domain.declaration.TermsType
import jakarta.persistence.Converter

@Converter(autoApply = true)
class TermsTypeConverter : AbstractBaseEnumConverter<TermsType>(TermsType::class.java)