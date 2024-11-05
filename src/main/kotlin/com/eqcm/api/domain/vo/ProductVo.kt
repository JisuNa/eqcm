package com.eqcm.api.domain.vo

class ProductVo(
    val id: Long,
    val name: String,
    val price: Int,
    val optionGroups: List<OptionGroup>
) {
    class OptionGroup(
        val id: Long,
        val name: String,
        val options: List<Option>
    ) {
        class Option(
            val id: Long,
            val name: String,
        )
    }
}
