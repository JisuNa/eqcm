package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

class NotAllowEmailLoginException: BaseException(GlobalResponseType.NOT_ALLOW_EMAIL_LOGIN)
