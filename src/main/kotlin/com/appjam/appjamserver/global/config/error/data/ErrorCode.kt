package com.appjam.appjamserver.global.config.error.data

import org.springframework.http.HttpStatus

enum class ErrorCode(
        val status: HttpStatus,
        val message: String,
) {
    //400
    FEIGN_BAD_REQUEST(HttpStatus.BAD_REQUEST, "Feign Bad Request"),

    FEIGN_FORBIDDEN_ERROR(HttpStatus.FORBIDDEN, "Feign Forbidden Error"),

    FEIGN_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Feign Server Error"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러")
}