package id.gits.ui_compose.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

/**
 * Created by Kudzoza
 * on 12/09/2022
 **/

object GitsAppTheme {
    val colors: GitsColor
        @Composable
        @ReadOnlyComposable
        get() = GitsLocalColors.current
    val typography: GitsTypography
        @Composable
        @ReadOnlyComposable
        get() = GitsLocalTypography.current
    val dimensions: GitsDimension
        @Composable
        @ReadOnlyComposable
        get() = GitsLocalDimension.current
}

@Composable
fun GitsTheme(
    colors: GitsColor = GitsAppTheme.colors,
    typography: GitsTypography = GitsAppTheme.typography,
    dimensions: GitsDimension = GitsAppTheme.dimensions,
    enableDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val rememberedColors = remember { colors.copy() }
    CompositionLocalProvider(
        GitsLocalColors provides rememberedColors,
        GitsLocalDimension provides dimensions,
        GitsLocalTypography provides typography
    ) {
        MaterialTheme(
            colors =
            if (isSystemInDarkTheme() && enableDarkTheme) darkColors()
            else lightColors(
                primary = colors.primary,
                primaryVariant = colors.primaryVariant,
                secondary = colors.secondary,
                background = colors.background,
                error = colors.error,
            )
        ) {
            content()
        }
    }
}