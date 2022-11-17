package id.gits.ui_compose.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Created by Kudzoza
 * on 12/11/2022
 **/

@Composable
fun GitsScaffold(
    modifier: Modifier = Modifier,
    gitsAppState: GitsAppState = rememberGitsAppState(),
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { GitsSnackBarHost(it) },
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    isFloatingActionButtonDocked: Boolean = false,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerGesturesEnabled: Boolean = true,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = MaterialTheme.colors.surface,
    drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
    drawerScrimColor: Color = DrawerDefaults.scrimColor,
    backgroundColor: Color = MaterialTheme.colors.background,
    contentColor: Color = contentColorFor(backgroundColor),
    content: @Composable (GitsAppState) -> Unit,
) {
    GitsTheme {
        Surface {
            Scaffold(
                modifier = modifier,
                scaffoldState = gitsAppState.scaffoldState,
                topBar = topBar,
                bottomBar = bottomBar,
                snackbarHost = snackbarHost,
                floatingActionButton = floatingActionButton,
                floatingActionButtonPosition = floatingActionButtonPosition,
                isFloatingActionButtonDocked = isFloatingActionButtonDocked,
                drawerContent = drawerContent,
                drawerGesturesEnabled = drawerGesturesEnabled,
                drawerShape = drawerShape,
                drawerElevation = drawerElevation,
                drawerBackgroundColor = drawerBackgroundColor,
                drawerContentColor = drawerContentColor,
                drawerScrimColor = drawerScrimColor,
                backgroundColor = backgroundColor,
                contentColor = contentColor
            ) {
                Column(Modifier.padding(it)) {
                    content(gitsAppState)
                }
            }
        }
    }
}