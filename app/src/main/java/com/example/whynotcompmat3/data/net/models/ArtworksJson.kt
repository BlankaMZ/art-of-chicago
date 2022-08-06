package com.example.whynotcompmat3.data.net.models

import com.example.whynotcompmat3.data.domain.models.ArtItem
import com.example.whynotcompmat3.data.domain.models.toArtItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtworksJson(
    @SerialName("pagination") val pagination: PaginationJson,
    @SerialName("data") val data: List<ArtItemJson>,
    @SerialName("config") val config: ConfigDataJson
)

@Serializable
data class PaginationJson(
    @SerialName("total") val total: Int,
    @SerialName("limit") val limit: Int,
    @SerialName("offset") val offset: Int,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("current_page") val currentPage: Int,
    @SerialName("next_url") val nextUrl: String,
)

fun ArtworksJson.toArtworksList(): List<ArtItem> =
    data.map { artItemJson -> artItemJson.toArtItem(config.iiifUrl) }
