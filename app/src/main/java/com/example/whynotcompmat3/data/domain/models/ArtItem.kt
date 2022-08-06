package com.example.whynotcompmat3.data.domain.models

import com.example.whynotcompmat3.data.net.models.ArtItemJson
import com.example.whynotcompmat3.data.net.models.ArtItemResultJson

data class ArtItem(
    val id: Int,
    val title: String,
    val placeOfOrigin: String,
    val artistName: String,
    val styleTitle: String,
    val imageUrl: String
)

fun ArtItemJson.toArtItem(urlForImage: String) = ArtItem(
    id = id,
    title = title,
    placeOfOrigin = placeOfOrigin ?: "",
    artistName = artistTitle ?: "",
    styleTitle = styleTitle ?: "",
    imageUrl = if (imageId != null) createImageUrl(imageId, urlForImage) else "",
)

fun ArtItemResultJson.toArtItem() = ArtItem(
    id = data.id,
    title = data.title,
    placeOfOrigin = data.placeOfOrigin ?: "",
    artistName = data.artistTitle ?: "",
    styleTitle = data.styleTitle ?: "",
    imageUrl = if (data.imageId != null) createImageUrl(data.imageId, config.iiifUrl) else "",
)

fun createImageUrl(imageId: String, urlForImage: String): String {
    return "$urlForImage/$imageId/$IMAGE_URL_END_DEFAULT"
}

const val IMAGE_URL_END_DEFAULT = "full/843,/0/default.jpg"
