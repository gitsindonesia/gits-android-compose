package id.gits.ui_compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun CardItemShimmerComponent(
    isLazyRow: Boolean = false,
) {

    val imageHeight = if (isLazyRow) 150.dp else 156.dp

    val modifier = if (isLazyRow) {
        Modifier
            .width(150.dp)
    } else {
        Modifier
            .fillMaxWidth()
    }

    Card(
        elevation = 4.dp, shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight)
                    .shimmer()
                    .background(color = Color.Gray)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp, start = 4.dp, top = 8.dp, end = 4.dp)
                    .height(15.dp)
                    .shimmer()
                    .background(color = Color.Gray)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 4.dp, top = 4.dp, end = 4.dp)
                    .height(15.dp)
                    .shimmer()
                    .background(color = Color.Gray)
            )
        }
    }

}