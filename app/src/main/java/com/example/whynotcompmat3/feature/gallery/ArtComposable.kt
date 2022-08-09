import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.whynotcompmat3.R
import com.example.whynotcompmat3.data.domain.models.ArtItem

@Composable
fun ArtItemInListComposable(
    art: ArtItem,
    onArtItemClicked: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_common))
                .clickable { onArtItemClicked() }
        ) {
            AsyncImage(
                model = art.imageUrl,
                contentDescription = stringResource(id = R.string.painting_description, art.title),
                placeholder = painterResource(id = R.drawable.image_placeholder),
                fallback = painterResource(id = R.drawable.ic_no_image),
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_common_small))
            )
            Text(
                art.title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_common_small))
            )
            Text(
                art.artistName.ifEmpty {
                    stringResource(
                        id = R.string.art_item_author_unknown
                    )
                },
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
