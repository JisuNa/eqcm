package com.eqcm.api.domain.vo

import com.eqcm.api.domain.declaration.TermsType
import com.eqcm.api.domain.declaration.Yn

data class TermsAgreement(
    val type: TermsType,
    val agreeYn: Yn
)
