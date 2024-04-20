package com.appjam.appjamserver.global.config.feign.exception

import com.appjam.appjamserver.global.config.error.data.ErrorCode
import com.appjam.appjamserver.global.config.error.exception.BusinessException

object FeignBadRequestException : BusinessException(ErrorCode.FEIGN_BAD_REQUEST) {

    private fun readResolve(): Any = FeignBadRequestException
}
