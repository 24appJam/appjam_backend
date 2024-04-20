package com.appjam.appjamserver.global.feign

import com.appjam.appjamserver.global.feign.dto.request.FeignCreateMusicRequest
import com.appjam.appjamserver.global.feign.dto.response.FeignMusicResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(url = "https://suno-api.xquare.app", name = "music-client")
interface MusicClient {
    @PostMapping("/api/custom_generate")
    fun createMusic(@RequestBody feignCreateMusicRequest: FeignCreateMusicRequest): List<FeignMusicResponse>

    @GetMapping("/api/get")
    fun getMusic(@RequestParam("ids") videoId: String): List<FeignMusicResponse>
}