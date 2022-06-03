package com.example.whynotcompmat3.feature.artItemdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = dimensionResource(id = R.dimen.padding_common_big))
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {}
        AsyncImage(
            model = art.imageUrl,
            contentDescription = stringResource(id = R.string.painting_description, art.title),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_common_small))
        )
    }
    Text(
        art.title,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_common_small))
    )
    Text(
        art.artistName,
        style = MaterialTheme.typography.bodyMedium,
    )
}


