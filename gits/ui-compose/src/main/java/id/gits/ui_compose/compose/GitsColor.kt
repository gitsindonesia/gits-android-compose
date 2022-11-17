package id.gits.ui_compose.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

/**
 * Created by Kudzoza
 * on 12/09/2022
 **/

private val colorPrimary = Color(0xFF00B7FF)
private val colorPrimaryVariant = Color(0xFF0689BD)
private val colorSecondary = Color(0xFFF38558)
private val colorSecondaryVariant = Color(0xFFD1511D)
private val colorTextPrimary = Color(0xFF555555)
private val colorTextSecondary = Color(0xFF888888)
private val colorBackground = Color(0xFFFFFFFF)
private val colorError = Color(0xFFE91E63)

class GitsColor(
    primary: Color = colorPrimary,
    primaryVariant: Color = colorPrimaryVariant,
    secondary: Color = colorSecondary,
    secondaryVariant: Color = colorSecondaryVariant,
    textPrimary: Color = colorTextPrimary,
    textSecondary: Color = colorTextSecondary,
    background: Color = colorBackground,
    error: Color = colorError,
) {
    var primary by mutableStateOf(primary)
        private set

    var primaryVariant by mutableStateOf(primaryVariant)
        private set

    var secondary by mutableStateOf(secondary)
        private set

    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set

    var textPrimary by mutableStateOf(textPrimary)
        private set

    var textSecondary by mutableStateOf(textSecondary)
        private set

    var background by mutableStateOf(background)
        private set

    var error by mutableStateOf(error)
        private set

    fun copy(
        primary: Color = this.primary,
        primaryVariant: Color = this.primaryVariant,
        secondary: Color = this.secondary,
        secondaryVariant: Color = this.secondaryVariant,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        background: Color = this.background,
        error: Color = this.error,
    ): GitsColor = GitsColor(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        textPrimary,
        textSecondary,
        background,
        error
    )
}