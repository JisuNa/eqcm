package com.eqcm.api.presentation.common.response

import com.eqcm.api.application.common.GlobalResponseType

class ErrorResponse(
    code: GlobalResponseType,
    message: String
) : BaseResponse(code, message)