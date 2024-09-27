package com.eqcm.api.domain.declaration

enum class Yn(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    Y("Y", "예"),
    N("N", "아니오")
}
