package id.gits.ui_compose.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.*
import com.valentinilk.shimmer.shimmer
import id.gits.ui_compose.helper.ImageLoaderInterface
import id.gits.ui_compose.helper.LoadPicture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

data class ImageBanner(
    val id: Int,
    val title: String,
    val banner: String,
)

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class, ExperimentalCoroutinesApi::class)
@Composable
fun ImageBannerComponent(
    data: List<ImageBanner>?,
    rootLayoutModifier: Modifier? = null,
    useIndicator: Boolean = false,
    actionListener: (ImageBanner) -> Unit,
) {
    val imageHeight = 180.dp
    //val resources = LocalContext.current.resources
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val rootModifier = rootLayoutModifier ?: Modifier.fillMaxWidth()

    Column(modifier = rootModifier) {
        if (data == null) {
            Box(
                modifier = rootModifier
                    .shimmer()
                    .background(color = Color.Gray)
            )
        } else {
            HorizontalPager(
                state = pagerState,
                count = data.size,
                modifier = Modifier.padding(vertical = 16.dp),
                // Add 32.dp horizontal padding to 'center' the pages
                contentPadding = PaddingValues(horizontal = 32.dp)
            ) { page ->
                Card(elevation = 8.dp, shape = RoundedCornerShape(10.dp), modifier =
                Modifier
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        // We animate the scaleX + scaleY, between 85% and 100%
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .fillMaxWidth()
                ) {
                    LoadPicture(
                        data[currentPage].banner, object : ImageLoaderInterface {
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
                                        .height(imageHeight)
                                        .clickable { actionListener(data[currentPage]) },
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                    )
                }
            }

            if (useIndicator) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                    //activeColor = Color(resources.getColor(R.color.colorBlueNav)),
                    //inactiveColor = Color(resources.getColor(R.color.greyLineChallenge)),
                    indicatorHeight = 9.dp,
                    indicatorWidth = 9.dp
                )
            }

            automateSlideBanner(
                coroutineScope,
                pagerState,
                data.size
            )
        }

    }

}

@OptIn(ExperimentalPagerApi::class)
fun automateSlideBanner(
    coroutineScope: CoroutineScope,
    pagerState: PagerState,
    dataSize: Int,
) {
    coroutineScope.launch() {
        delay(3000L)
        var nextPage = pagerState.currentPage + 1
        if (nextPage >= dataSize)
            nextPage = 0

        pagerState.animateScrollToPage(nextPage, pagerState.currentPageOffset)

        automateSlideBanner(coroutineScope, pagerState, dataSize)
    }
}

