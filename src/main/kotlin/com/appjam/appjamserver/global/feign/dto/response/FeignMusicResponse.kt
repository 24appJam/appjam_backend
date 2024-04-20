package com.appjam.appjamserver.global.feign.dto.response

data class FeignMusicResponse(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val lyric: String,
    val audioUrl: String?,
    val videoUrl: String?,
    val status: String,
    val prompt: String,
    val type: String?,
    val tags: String?
)