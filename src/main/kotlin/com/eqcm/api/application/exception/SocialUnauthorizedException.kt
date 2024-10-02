package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

class SocialUnauthorizedException: BaseException(GlobalResponseType.SOCIAL_UNAUTHORIZED)
