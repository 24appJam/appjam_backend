package com.appjam.appjamserver.global.config.error.exception

import com.appjam.appjamserver.global.config.error.data.ErrorCode

open class BusinessException(val errorCode: ErrorCode): RuntimeException(errorCode.message)