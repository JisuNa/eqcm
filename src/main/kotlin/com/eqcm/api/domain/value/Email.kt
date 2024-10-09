package com.eqcm.api.domain.value

@JvmInline
value class Email(val value: String) {
    init {
        require(isNotValid(value).not()) { "이메일 형식을 확인해주세요." }
    }

    companion object {
        private fun isNotValid(value: String) = !REGEX_EMAIL.matches(value)
        private val REGEX_EMAIL = Regex("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")
    }
}
