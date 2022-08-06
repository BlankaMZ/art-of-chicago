package com.example.whynotcompmat3.data.net.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtItemJson(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("place_of_origin") val placeOfOrigin: String?,
    @SerialName("artist_title") val artistTitle: String?,
    @SerialName("style_title") val styleTitle: String?,
    @SerialName("image_id") val imageId: String?,
)

@Serializable
data class ConfigDataJson(
    @SerialName("iiif_url") val iiifUrl: String
)
