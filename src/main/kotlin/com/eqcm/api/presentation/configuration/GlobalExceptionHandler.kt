package com.eqcm.api.presentation.configuration

import com.eqcm.api.application.common.GlobalResponseType
import com.eqcm.api.application.exception.BaseException
import com.eqcm.api.presentation.common.response.ErrorResponse
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ErrorResponse {
        return ErrorResponse(GlobalResponseType.BAD_REQUEST, "입력 값을 확인해주세요. ${e.bindingResult.fieldErrors[0].field}")
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ErrorResponse {
        return ErrorResponse(GlobalResponseType.BAD_REQUEST, e.message ?: "")
    }
}
