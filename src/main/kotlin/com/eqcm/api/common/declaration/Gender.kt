package com.eqcm.api.common.declaration

import jakarta.persistence.Converter

enum class Gender(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    MALE("M", "남자"),
    FEMALE("F", "여자")
}

@Converter(autoApply = true)
class GenderConverter : AbstractBaseEnumConverter<Gender>(Gender::class.java)
