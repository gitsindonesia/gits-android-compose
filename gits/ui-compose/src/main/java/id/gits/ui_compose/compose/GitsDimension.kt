package id.gits.modular.core.compose

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Kudzoza
 * on 12/09/2022
 **/

data class GitsDimension(
    val paddingTiny: Dp = 2.dp,
    val paddingSmall: Dp = 4.dp,
    val paddingMedium: Dp = 8.dp,
    val paddingBig: Dp = 12.dp,
    val paddingLarge: Dp = 24.dp,
)

internal val GitsLocalDimension = staticCompositionLocalOf { GitsDimension() }