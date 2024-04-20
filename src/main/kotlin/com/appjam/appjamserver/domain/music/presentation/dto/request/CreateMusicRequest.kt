package com.appjam.appjamserver.domain.music.presentation.dto.request

data class CreateMusicRequest(
    val prompt: String,
    val atmosphere: String,
    val keywords: String,
    val additionalRequirements: String
)
