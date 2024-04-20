package com.appjam.appjamserver.domain.music.presentation.dto.response

data class GetMusicResponse(
    val imageUrl: String?,
    val musicId: Long,
    val videoUrl: String?,
    val status: String
)
