package com.example.whynotcompmat3.data.net.repositories

import com.example.whynotcompmat3.data.domain.models.toArtItem
import com.example.whynotcompmat3.data.net.api.ArtInstituteOfChicagoApi
import com.example.whynotcompmat3.data.net.models.toArtworksList
import javax.inject.Inject

class ArtworksRepository @Inject constructor(
    private val artworksApi: ArtInstituteOfChicagoApi
) {
    suspend fun artworks() = artworksApi.artworks().toArtworksList()

    suspend fun artItem(id: Int) = artworksApi.getArtItem(id).toArtItem()
}
