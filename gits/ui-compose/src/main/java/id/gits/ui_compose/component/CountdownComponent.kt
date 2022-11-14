package id.gits.ui_compose.component

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CountdownComponent(hour: Int, minute: Int, second: Int) {
    Surface(shape = RoundedCornerShape(16.dp), color = Color.Red) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "icon timer",
                tint = Color.White
            )
            Spacer(modifier = Modifier.padding(4.dp))

            val splitterHour = formatCountNumber(hour)
            val splitterMinute = formatCountNumber(minute)
            val splitterSecond = formatCountNumber(second)

            for (charInt in splitterHour) {
                AnimatedText(count = charInt)
            }
            ColonText()
            for (charInt in splitterMinute) {
                AnimatedText(count = charInt)
            }
            ColonText()
            for (charInt in splitterSecond) {
                AnimatedText(count = charInt)
            }
        }
    }
}

@Composable
private fun ColonText() {
    Text(text = " : ", color = Color.White)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimatedText(count: Int) {
    AnimatedContent(
        targetState = count,
        transitionSpec = {
            // Compare the incoming number with the previous number.
            if (targetState > initialState) {
                // If the target number is larger, it slides up and fades in
                // while the initial (smaller) number slides up and fades out.
                slideInVertically { height -> height } + fadeIn() with
                        slideOutVertically { height -> -height } + fadeOut()
            } else {
                // If the target number is smaller, it slides down and fades in
                // while the initial number slides down and fades out.
                slideInVertically { height -> -height } + fadeIn() with
                        slideOutVertically { height -> height } + fadeOut()
            }.using(
                // Disable clipping since the faded slide-in/out should
                // be displayed out of bounds.
                SizeTransform(clip = false)
            )
        }
    ) {
        Text(text = "$count", color = Color.White)
    }
}

private fun formatCountNumber(value: Int): Array<Int> {
    return if (value < 10) arrayOf(0, value) else "$value".map { it.toString().toInt() }
        .toTypedArray()
}
