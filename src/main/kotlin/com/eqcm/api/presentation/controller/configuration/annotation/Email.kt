package com.eqcm.api.presentation.controller.configuration.annotation

import com.eqcm.api.presentation.controller.configuration.validator.EmailFormatValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EmailFormatValidator::class])
annotation class EmailFormat(
    val message: String = "Invalid email format",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
