package com.appjam.appjamserver.global.config.feign.exception

import com.appjam.appjamserver.global.config.error.data.ErrorCode
import com.appjam.appjamserver.global.config.error.exception.BusinessException

object FeignDefaultException : BusinessException(ErrorCode.FEIGN_SERVER_ERROR) {
    private fun readResolve(): Any = FeignDefaultException
}
