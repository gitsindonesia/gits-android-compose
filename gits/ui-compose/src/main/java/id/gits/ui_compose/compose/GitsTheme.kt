package id.gits.ui_compose.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Created by Kudzoza
 * on 12/09/2022
 **/

@Composable
fun GitsTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        if (isSystemInDarkTheme() && GitsScheme.enableDarkTheme.value) Color.DarkGray
        else Color.White
    )
    MaterialTheme(
        colors = if (isSystemInDarkTheme() && GitsScheme.enableDarkTheme.value) darkColors(
            primary = GitsScheme.colorScheme.value.primary,
            primaryVariant = GitsScheme.colorScheme.value.primaryVariant,
            secondary = GitsScheme.colorScheme.value.secondary,
            secondaryVariant = GitsScheme.colorScheme.value.secondaryVariant,
            background = GitsScheme.colorScheme.value.background,
            error = GitsScheme.colorScheme.value.error,
        )
        else lightColors(
            primary = GitsScheme.colorScheme.value.primary,
            primaryVariant = GitsScheme.colorScheme.value.primaryVariant,
            secondary = GitsScheme.colorScheme.value.secondary,
            secondaryVariant = GitsScheme.colorScheme.value.secondaryVariant,
            background = GitsScheme.colorScheme.value.background,
            error = GitsScheme.colorScheme.value.error,
        )
    ) {
        content()
    }
}