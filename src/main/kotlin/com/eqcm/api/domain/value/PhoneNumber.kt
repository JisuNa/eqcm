package com.eqcm.api.domain.value

@JvmInline
value class PhoneNumber(val value: String) {
    init {
        require(isNotValid(value).not()) { "전화번호 형식을 확인해주세요." }
    }

    companion object {
        private fun isNotValid(value: String) = !REGEX_PHONE_NUMBER.matches(value)
        private val REGEX_PHONE_NUMBER = Regex("^010-\\d{4}-\\d{4}$")
    }
}
