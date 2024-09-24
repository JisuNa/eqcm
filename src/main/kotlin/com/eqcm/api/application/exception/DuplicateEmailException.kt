package com.eqcm.api.application.exception

import com.eqcm.api.application.common.GlobalResponseType

class DuplicateEmailException : BaseException(GlobalResponseType.DUPLICATE_EMAIL)