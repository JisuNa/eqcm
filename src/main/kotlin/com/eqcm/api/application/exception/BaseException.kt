package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

open class BaseException(
    val responseCode: GlobalResponseType,
    message: String? = null,
) : RuntimeException(message ?: responseCode.defaultMessage)
