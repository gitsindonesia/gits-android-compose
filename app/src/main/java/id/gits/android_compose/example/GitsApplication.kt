package id.gits.android_compose.example

import android.app.Application
import androidx.compose.ui.graphics.Color
import id.gits.ui_compose.compose.GitsColor

/**
 * Created by Kudzoza
 * on 15/11/2022
 **/

class GitsApplication : Application() {

    val primaryTheme = GitsColor()

    val secondaryTheme = GitsColor(
        primary = Color(0xFF32EB4B),
        primaryVariant = Color(0xFF189B29),
        secondary = Color(0xFF14A9EE),
        secondaryVariant = Color(0xFF1875A0),
        textPrimary = Color(0xFF555555),
        textSecondary = Color(0xFF888888),
        background = Color(0xFFFFFFFF),
        error = Color(0xFFE91E63),
    )

    override fun onCreate() {
        super.onCreate()
    }

}