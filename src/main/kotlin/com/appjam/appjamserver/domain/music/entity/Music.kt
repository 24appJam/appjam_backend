package com.appjam.appjamserver.domain.music.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob


@Entity(name = "tbl_music")
class Music(
    id: Long? = null,
    story: String,
    atmosphere: String,
    keywords: String,
    additionalRequirements: String,
    audioId: String,
    audioUrl: String?,
    videoUrl: String?,
    imageUrl: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = id
        protected set

    @Column(columnDefinition = "TEXT")
    var story: String = story
        protected set

    var atmosphere: String = atmosphere
        protected set

    var keywords: String = keywords
        protected set

    var additionalRequirements: String = additionalRequirements
        protected set

    var audioId: String = audioId
        protected set

    var audioUrl: String? = audioUrl
        protected set

    var videoUrl: String? = videoUrl
        protected set

    var imageUrl: String? = imageUrl
        protected set
}