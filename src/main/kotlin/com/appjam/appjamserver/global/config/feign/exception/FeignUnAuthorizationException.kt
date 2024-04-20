package com.appjam.appjamserver.global.config.feign.exception

import com.appjam.appjamserver.global.config.error.data.ErrorCode
import com.appjam.appjamserver.global.config.error.exception.BusinessException


object FeignUnAuthorizationException : BusinessException(ErrorCode.FEIGN_FORBIDDEN_ERROR) {
    private fun readResolve(): Any = FeignUnAuthorizationException
}
