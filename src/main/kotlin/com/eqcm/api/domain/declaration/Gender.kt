package com.eqcm.api.domain.declaration

enum class Gender(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    MALE("M", "남자"),
    FEMALE("F", "여자")
}
