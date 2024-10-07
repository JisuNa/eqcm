package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

class ExpiredVerifyNumberException : BaseException(GlobalResponseType.EXPIRED_VERIFY_NUMBER)
