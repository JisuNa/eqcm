package com.eqcm.api.application.common

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.http.HttpStatus

enum class GlobalResponseType(
    @get:JsonValue
    val code: String,
    val httpStatus: HttpStatus,
    val defaultMessage: String
) {
    OK("200", HttpStatus.OK, "요청이 성공하였습니다."),
    BAD_REQUEST("400", HttpStatus.BAD_REQUEST, "요청하신 데이터가 올바르지 않습니다."),
    DUPLICATE_EMAIL("403", HttpStatus.FORBIDDEN, "이미 사용중인 이메일입니다."),
}