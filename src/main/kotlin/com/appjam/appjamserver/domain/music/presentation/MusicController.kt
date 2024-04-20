package com.appjam.appjamserver.domain.music.presentation

import com.appjam.appjamserver.domain.music.presentation.dto.request.CreateMusicRequest
import com.appjam.appjamserver.domain.music.presentation.dto.response.GetMusicResponse
import com.appjam.appjamserver.domain.music.service.MusicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/music")
@RestController
class MusicController(
    private val musicService: MusicService
) {
    @PostMapping
    fun createMusic(@RequestBody createMusicRequest: CreateMusicRequest) {
        musicService.createMusic(createMusicRequest)
    }

    @GetMapping("/all")
    fun getAllMusic(): List<GetMusicResponse> {
        return musicService.getAllMusic()
    }
}