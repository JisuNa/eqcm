package com.eqcm.api.presentation.controller.configuration

import com.eqcm.api.application.common.GlobalResponseType
import com.eqcm.api.application.exception.BaseException
import com.eqcm.api.presentation.common.response.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(e: BaseException): ErrorResponse {
        return ErrorResponse(code = e.responseCode, message = e.message ?: "")
    }

    @ExceptionHandler(HandlerMethodValidationException::class)
    fun handleHandlerMethodValidationException(e: HandlerMethodValidationException): ErrorResponse {
        return ErrorResponse(GlobalResponseType.BAD_REQUEST, e.reason ?: "")
    }
}
