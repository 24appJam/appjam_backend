package com.appjam.appjamserver.domain.music.service

import com.appjam.appjamserver.domain.music.entity.Music
import com.appjam.appjamserver.domain.music.presentation.dto.request.CreateMusicRequest
import com.appjam.appjamserver.domain.music.presentation.dto.response.GetMusicResponse
import com.appjam.appjamserver.domain.music.repository.MusicRepository
import com.appjam.appjamserver.global.feign.MusicClient
import com.appjam.appjamserver.global.feign.PromptClient
import com.appjam.appjamserver.global.feign.dto.request.CreatePromptRequest
import com.appjam.appjamserver.global.feign.dto.request.FeignCreateMusicRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class MusicService(
    private val musicClient: MusicClient,
    private val musicRepository: MusicRepository,
    private val promptClient: PromptClient
) {
    fun createMusic(createMusicRequest: CreateMusicRequest) {


        val promptResponse = promptClient.createPrompt(
            CreatePromptRequest(
                keyword = createMusicRequest.keywords,
                content = createMusicRequest.prompt,
                mood = createMusicRequest.atmosphere,
                additional = createMusicRequest.additionalRequirements
            )
        )

        println(promptResponse.generatedText.generatedText)

        val feignRequest = createMusicRequest.run {
            FeignCreateMusicRequest(
                prompt = promptResponse.generatedText.generatedText,
                tags = keywords,
                title = title
            )
        }
        val response = musicClient.createMusic(feignRequest)

        response.map {
            val music = Music(
                story = createMusicRequest.prompt,
                atmosphere = createMusicRequest.atmosphere,
                keywords = createMusicRequest.keywords,
                additionalRequirements = createMusicRequest.additionalRequirements,
                audioId = it.id,
                audioUrl = it.audioUrl,
                videoUrl = it.videoUrl,
                imageUrl = it.imageUrl
            )

            musicRepository.save(music)
        }
    }

    fun getAllMusic(): List<GetMusicResponse> {
        val musics = musicRepository.findAll()

        val response = musics.map {
            val feignResponse = musicClient.getMusic(it.audioId)
            val videoUrl = feignResponse[0].videoUrl
            val status = feignResponse[0].status
            GetMusicResponse(
                imageUrl = it.imageUrl,
                musicId = it.id!!,
                videoUrl = videoUrl,
                status = status
            )
        }.toList()

        return response
    }
}