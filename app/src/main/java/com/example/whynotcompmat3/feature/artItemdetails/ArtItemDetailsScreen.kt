package com.example.whynotcompmat3.feature.artItemdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.whynotcompmat3.R
import com.example.whynotcompmat3.data.domain.models.ArtItem
import com.example.whynotcompmat3.feature.other.ErrorMessageCentered
import com.example.whynotcompmat3.feature.other.LoadingComposable

@Composable
fun ArtItemDetailsScreen(imageId: String) {
    val viewModel = hiltViewModel<ArtItemDetailsVM>()

    when (val viewState = viewModel.viewState) {
        is ArtItemDetailsVS.Loading -> {
            LoadingComposable()
        }
        is ArtItemDetailsVS.Error -> {
            ErrorMessageCentered()
        }
        is ArtItemDetailsVS.ArtItemDetails -> {
            ArtItemDetailsComposable(viewState.artItem)
        }
    }
}

@Composable
fun ArtItemDetailsComposable(art: ArtItem) {

    Column(
        modifier = Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_common_big),
                horizontal = dimensionResource(id = R.dimen.padding_common)
            )
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = art.imageUrl,
                contentDescription = stringResource(id = R.string.painting_description, art.title),
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_common))
            )
        }
        ArtistDataSet(stringResource(id = R.string.art_item_title), art.title)
        ArtistDataSet(stringResource(id = R.string.art_item_artist_name), art.artistName)
        ArtistDataSet(stringResource(id = R.string.art_item_place_of_origin), art.placeOfOrigin)
        ArtistDataSet(
            stringResource(id = R.string.art_item_style),
            if (art.styleTitle.isNullOrEmpty()) stringResource(
                id = R.string.art_item_no_data
            ) else art.styleTitle
        )
    }
}

@Composable
fun ArtistDataSet(title: String, data: String) {
    Column(
        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_common_small))
    ) {
        Text(
            title,
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            data,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}
