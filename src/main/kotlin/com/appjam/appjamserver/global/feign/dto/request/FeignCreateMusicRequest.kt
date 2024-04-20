package com.appjam.appjamserver.global.feign.dto.request

data class FeignCreateMusicRequest (
    val prompt: String,
    val tags: String,
    val makeInstrumental: Boolean = true,
    val waitAudio: Boolean = false,
    val title: String
)