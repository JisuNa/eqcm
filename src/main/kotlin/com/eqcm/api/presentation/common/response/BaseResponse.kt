package com.eqcm.api.presentation.common.response

import com.eqcm.api.application.common.GlobalResponseType

open class BaseResponse(
    val code: GlobalResponseType,
    val message: String = code.defaultMessage
)
