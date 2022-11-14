package id.gits.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import id.gits.ui_compose.helper.ImageLoaderInterface
import id.gits.ui_compose.helper.LoadPicture

data class CardItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageUrl: String,
)

@Composable
fun CardItemComponent(
    item: CardItem,
    isLazyRow: Boolean = false,
    actionListener: (Int) -> Unit,
) {

    val imageHeight = if (isLazyRow) 150.dp else 156.dp

    val modifier = if (isLazyRow) {
        Modifier
            .width(150.dp)
            .clickable {
                actionListener(item.id)
            }
    } else {
        Modifier
            .fillMaxWidth()
            .clickable {
                actionListener(item.id)
            }
    }

    Card(
        elevation = 4.dp, shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            LoadPicture(item.imageUrl, object : ImageLoaderInterface {
                @Composable
                override fun OnLoading() {
                    Box(
                        modifier = Modifier
                            .height(imageHeight)
                            .fillMaxWidth()
                            .shimmer()
                            .background(color = Color.Gray)
                    )
                }

                @Composable
                override fun OnSuccess(bitmap: ImageBitmap) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = "news-image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(imageHeight),
                        contentScale = ContentScale.Crop
                    )
                }

            })

            Text(
                text = item.title,
                modifier = Modifier.padding(bottom = 4.dp, start = 4.dp, top = 8.dp, end = 4.dp),
                maxLines = 1,
                style = MaterialTheme.typography.subtitle2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = item.subtitle,
                modifier = Modifier
                    .padding(bottom = 8.dp, start = 4.dp, top = 4.dp, end = 4.dp),
                maxLines = 1,
                style = MaterialTheme.typography.body2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}

