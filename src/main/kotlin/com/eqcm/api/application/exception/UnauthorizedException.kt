package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

class UnauthorizedException: BaseException(GlobalResponseType.UNAUTHORIZED)
