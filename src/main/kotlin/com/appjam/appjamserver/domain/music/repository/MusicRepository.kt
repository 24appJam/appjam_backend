package com.appjam.appjamserver.domain.music.repository

import com.appjam.appjamserver.domain.music.entity.Music
import org.springframework.data.jpa.repository.JpaRepository

interface MusicRepository : JpaRepository<Music, Long>