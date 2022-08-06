package com.example.whynotcompmat3.data.net.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtItemResultJson(
    @SerialName("data") val data: ArtItemJson,
    @SerialName("config") val config: ConfigDataJson
)
