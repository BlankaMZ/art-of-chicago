package com.example.whynotcompmat3.feature.gallery

import com.example.whynotcompmat3.data.domain.models.ArtItem

sealed class GalleryOfArtworksVS {

    object Loading : GalleryOfArtworksVS()

    object Error : GalleryOfArtworksVS()

    data class ArtworksList(
        val artworks: List<ArtItem>
    ) : GalleryOfArtworksVS()
}