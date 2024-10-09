package com.eqcm.api.domain.value

@JvmInline
value class Birthday(val value: String) {
    init {
        require(isNotValid(value).not()) { "생년월일 형식을 확인해주세요." }
    }

    companion object {
        private fun isNotValid(value: String) = !REGEX_YYYY_MM_DD.matches(value)
        private val REGEX_YYYY_MM_DD = Regex("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")
    }
}
