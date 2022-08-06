package com.example.whynotcompmat3.data.net.api

import com.example.whynotcompmat3.data.net.models.ArtItemResultJson
import com.example.whynotcompmat3.data.net.models.ArtworksJson
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtInstituteOfChicagoApi {

    @GET("artworks?fields=id,title,place_of_origin,artist_title,style_title,image_id")
    suspend fun artworks(): ArtworksJson

    @GET("artworks/{imageId}")
    suspend fun getArtItem(@Path("imageId") imageId: Int): ArtItemResultJson
}
