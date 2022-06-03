package com.example.whynotcompmat3.data.net.repositories

import com.example.whynotcompmat3.data.net.api.ArtInstituteOfChicagoApi
import javax.inject.Inject

class ArtworksRepository @Inject constructor(
    private val artworksApi: ArtInstituteOfChicagoApi
) {
    suspend fun artworks() = artworksApi.artworks()

    suspend fun artItem(id: Int) = artworksApi.getArtItem(id)
}
