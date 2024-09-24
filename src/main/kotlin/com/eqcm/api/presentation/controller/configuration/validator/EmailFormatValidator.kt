package com.eqcm.api.presentation.controller.configuration.validator

import com.eqcm.api.presentation.controller.configuration.annotation.EmailFormat
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailFormatValidator : ConstraintValidator<EmailFormat, String> {
    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        return EMAIL_REGEX.matches(value)
    }

    companion object {
        val EMAIL_REGEX = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    }
}
