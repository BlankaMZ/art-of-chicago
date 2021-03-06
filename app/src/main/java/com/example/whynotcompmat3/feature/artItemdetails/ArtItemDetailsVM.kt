package com.example.whynotcompmat3.feature.artItemdetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whynotcompmat3.data.domain.models.toArtItem
import com.example.whynotcompmat3.data.net.models.toArtworksList
import com.example.whynotcompmat3.data.net.repositories.ArtworksRepository
import com.example.whynotcompmat3.feature.gallery.GalleryOfArtworksVS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtItemDetailsVM @Inject constructor(
    private val artworksRepository: ArtworksRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var viewState by mutableStateOf<ArtItemDetailsVS>(ArtItemDetailsVS.Loading)

    init{
        val argument = savedStateHandle.get<String>("imageId").orEmpty()
        viewModelScope.launch {
            viewState = try {
                var result = artworksRepository.artItem(argument.toInt())
                ArtItemDetailsVS.ArtItemDetails(artItem = result.toArtItem())
            } catch (e: Throwable) {
                ArtItemDetailsVS.Error
            }
        }
    }
}