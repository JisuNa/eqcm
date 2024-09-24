package com.eqcm.api.common.declaration

import jakarta.persistence.Converter

enum class Yn(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    Y("Y", "예"),
    N("N", "아니오")
}

@Converter(autoApply = true)
class YnConverter : AbstractBaseEnumConverter<Yn>(Yn::class.java)
