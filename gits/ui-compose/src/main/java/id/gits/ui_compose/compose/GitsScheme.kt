package id.gits.ui_compose.compose

import androidx.compose.runtime.mutableStateOf

/**
 * Created by Kudzoza
 * on 18/11/2022
 **/

object GitsScheme {

    val colorScheme = mutableStateOf(GitsColor())
    val dimensionScheme = mutableStateOf(GitsDimension())
    val typographyScheme = mutableStateOf(GitsTypography())
    val enableDarkTheme = mutableStateOf(false)

}
