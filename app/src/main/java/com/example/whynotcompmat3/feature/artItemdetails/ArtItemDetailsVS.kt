package com.example.whynotcompmat3.feature.artItemdetails

import com.example.whynotcompmat3.data.domain.models.ArtItem

sealed class ArtItemDetailsVS {

    object Loading : ArtItemDetailsVS()

    object Error : ArtItemDetailsVS()

    data class ArtItemDetails(
        val artItem: ArtItem
    ) : ArtItemDetailsVS()
}
