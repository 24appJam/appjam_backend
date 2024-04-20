package com.appjam.appjamserver.global.feign

import com.appjam.appjamserver.global.feign.dto.request.CreatePromptRequest
import com.appjam.appjamserver.global.feign.dto.response.CreatePromptResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "prompt-client", url = "172.16.21.174:8000")
interface PromptClient {
    @PostMapping("/process-prompt")
    fun createPrompt(@RequestBody createPromptRequest: CreatePromptRequest): CreatePromptResponse
}