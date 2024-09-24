package com.eqcm.api.presentation.common.response

import com.eqcm.api.application.common.GlobalResponseType

class SingleResponse<T>(
    val data: T,
    code: GlobalResponseType = GlobalResponseType.OK
) : BaseResponse(code)
