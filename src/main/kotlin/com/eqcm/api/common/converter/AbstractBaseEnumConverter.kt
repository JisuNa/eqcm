package com.eqcm.api.common.converter

import com.eqcm.api.application.exception.InvalidEnumCodeInDbDataException
import com.eqcm.api.domain.declaration.BaseEnum
import jakarta.persistence.AttributeConverter

open class AbstractBaseEnumConverter<E>(
    private val targetBaseEnumClass: Class<E>
) : AttributeConverter<E, String> where E : Enum<E>, E : BaseEnum {
    override fun convertToDatabaseColumn(attribute: E): String {
        return attribute.dbCode
    }

    override fun convertToEntityAttribute(dbData: String): E {
        targetBaseEnumClass.enumConstants.forEach {
            if (it.dbCode == dbData) {
                return it
            }
        }

        throw InvalidEnumCodeInDbDataException(
            enumClass = targetBaseEnumClass,
            dbData = dbData
        )
    }
}