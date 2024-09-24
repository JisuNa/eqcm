package com.eqcm.api.common.declaration

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
        return "" as E
//        throw InvalidEnumCodeInDbDataException(
//            enumClass = targetBaseEnumClass,
//            dbData = dbData
//        )
    }
}