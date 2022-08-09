import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.whynotcompmat3.R
import com.example.whynotcompmat3.data.domain.models.ArtItem
import com.example.whynotcompmat3.feature.gallery.GalleryOfArtworksVM
import com.example.whynotcompmat3.feature.gallery.GalleryOfArtworksVS
import com.example.whynotcompmat3.feature.other.ErrorMessageCentered
import com.example.whynotcompmat3.feature.other.LoadingComposable

@Composable
fun GalleryOfArtworksScreen(navController: NavController) {

    val viewModel = hiltViewModel<GalleryOfArtworksVM>()
    when (val viewState = viewModel.viewState) {
        is GalleryOfArtworksVS.Loading -> {
            LoadingComposable()
        }
        is GalleryOfArtworksVS.Error -> {
            ErrorMessageCentered()
        }
        is GalleryOfArtworksVS.ArtworksList -> {
            GalleryOfArtworksComposable(viewState.artworks, navController)
        }
    }
}

@Composable
fun GalleryOfArtworksComposable(
    artworks: List<ArtItem>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.padding_common)
            )
    ) {
        Text(
            stringResource(id = R.string.gallery_screen_title),
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_common))
        )
        Divider()
        LazyColumn {
            items(artworks) { artItem ->
                ArtItemInListComposable(
                    artItem,
                    onArtItemClicked = {
                        navController.navigate("artItemDetails/${artItem.id}")
                    }
                )
                Divider()
            }
        }
    }
}
