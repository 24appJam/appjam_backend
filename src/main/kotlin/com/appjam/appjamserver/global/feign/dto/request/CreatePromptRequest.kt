package com.appjam.appjamserver.global.feign.dto.request

data class CreatePromptRequest(
    val keyword: String,
    val content: String,
    val mood: String,
    val additional: String
)
