package id.gits.ui_compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun OneLineShimmer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(15.dp)
            .shimmer()
            .background(color = Color.Gray)
    )
}

@Composable
fun TwoLineShimmer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(30.dp)
            .shimmer()
            .background(color = Color.Gray)
    )
}

@Composable
fun TwoLineSmallShimmer() {
    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .width(100.dp)
            .height(30.dp)
            .shimmer()
            .background(color = Color.Gray)
    )
}

@Composable
fun SevenLineShimmer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(120.dp)
            .shimmer()
            .background(color = Color.Gray)
    )
}