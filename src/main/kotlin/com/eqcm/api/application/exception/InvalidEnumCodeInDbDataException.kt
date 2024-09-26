package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

class InvalidEnumCodeInDbDataException(
    enumClass: Class<out Enum<*>>,
    dbData: String,
) : BaseException(
    GlobalResponseType.INVALID_ENUM_CODE_IN_DB_DATA,
    "Invalid enum code in DB data: $dbData for enum class: ${enumClass.name}"
)
