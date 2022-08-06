package com.example.whynotcompmat3.feature.gallery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whynotcompmat3.data.net.models.toArtworksList
import com.example.whynotcompmat3.data.net.repositories.ArtworksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryOfArtworksVM @Inject constructor(
    private val artworksRepository: ArtworksRepository,
) : ViewModel() {

    var viewState by mutableStateOf<GalleryOfArtworksVS>(GalleryOfArtworksVS.Loading)

    init {
        viewModelScope.launch {
            viewState = try {
                var result = artworksRepository.artworks()
                GalleryOfArtworksVS.ArtworksList(artworks = result)
            } catch (e: Throwable) {
                GalleryOfArtworksVS.Error
            }
        }
    }

}