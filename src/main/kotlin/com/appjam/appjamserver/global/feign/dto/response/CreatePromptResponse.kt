package com.appjam.appjamserver.global.feign.dto.response

data class CreatePromptResponse(
    val generatedText: GeneratedText
)

data class GeneratedText(
    val generatedText: String
)