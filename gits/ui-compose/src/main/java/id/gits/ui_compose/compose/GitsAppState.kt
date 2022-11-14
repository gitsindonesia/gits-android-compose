package id.gits.ui_compose.compose

import android.content.res.Resources
import androidx.compose.material.*
import androidx.compose.material.SnackbarResult.ActionPerformed
import androidx.compose.material.SnackbarResult.Dismissed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.gits.modular.core.compose.GitsColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Kudzoza
 * on 11/11/2022
 **/

class GitsAppState(
    val scaffoldState: ScaffoldState,
    val coroutineScope: CoroutineScope,
    val navController: NavHostController,
    val resources: Resources,
) {

    fun showSnackbar(
        message: String,
        label: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short,
        onActionPerformed: () -> Unit = {},
        onDismiss: () -> Unit = {},
    ) {
        coroutineScope.launch {
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                message,
                label,
                duration
            )
            when (snackbarResult) {
                Dismissed -> onDismiss.invoke()
                ActionPerformed -> onActionPerformed.invoke()
            }
        }
    }

}

@Composable
fun GitsSnackBarHost(hostState: SnackbarHostState) {
    SnackbarHost(hostState) { data ->
        Snackbar(
            actionColor = GitsColor().primary,
            backgroundColor = GitsColor().background,
            contentColor = GitsColor().textPrimary,
            snackbarData = data
        )
    }
}

@Composable
fun rememberGitsAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = LocalContext.current.resources,
) = remember(scaffoldState, coroutineScope, navController, resources) {
    GitsAppState(scaffoldState, coroutineScope, navController, resources)
}
