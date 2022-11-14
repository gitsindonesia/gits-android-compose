package id.gits.ui_compose.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalCardItemComponent(
    data: List<CardItem>,
    modifier: Modifier? = Modifier,
    actionListener: (Int) -> Unit,
) {
    LazyRow(modifier = Modifier.padding(start = 16.dp)) {
        items(items = data) { item ->
            CardItemComponent(
                item = item,
                actionListener = actionListener,
                isLazyRow = true
            )
        }
    }
}