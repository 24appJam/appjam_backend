package com.appjam.appjamserver.global.config.feign.error

import com.appjam.appjamserver.global.config.feign.exception.FeignBadRequestException
import com.appjam.appjamserver.global.config.feign.exception.FeignDefaultException
import com.appjam.appjamserver.global.config.feign.exception.FeignForbiddenException
import com.appjam.appjamserver.global.config.feign.exception.FeignUnAuthorizationException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {

        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizationException
                403 -> throw FeignForbiddenException
                else -> throw FeignDefaultException
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }
}
