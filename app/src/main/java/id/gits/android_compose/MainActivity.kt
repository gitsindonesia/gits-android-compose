package id.gits.android_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.gits.android_compose.example.Index
import id.gits.modular.core.compose.GitsScaffold
import id.gits.ui_compose.component.CardItem
import id.gits.ui_compose.component.CardItemComponent
import id.gits.ui_compose.compose.rememberGitsAppState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val gitsAppState = rememberGitsAppState()
            var title by remember { mutableStateOf("Gits Component") }

            LaunchedEffect(gitsAppState.navController) {
                gitsAppState.navController.currentBackStackEntryFlow.collect { backStackEntry ->
                    title = if (backStackEntry.destination.route == "index")
                        "Gits Component"
                    else
                        backStackEntry.destination.route.orEmpty()
                }
            }

            GitsScaffold(
                gitsAppState = gitsAppState,
                topBar = {
                    TopAppBar(
                        navigationIcon = if (title == "Gits Component") null
                        else {
                            {
                                IconButton(onClick = {
                                    gitsAppState.navController.popBackStack()
                                }) {
                                    Icon(Icons.Outlined.ArrowBack, null)
                                }
                            }
                        },
                        title = { Text(text = title) }
                    )
                }
            ) {
                NavGraph(
                    navHostController = gitsAppState.navController,
                    showMessage = { message ->
                        gitsAppState.showSnackbar(message)
                    }
                )
            }
        }
    }

    @Composable
    fun NavGraph(
        navHostController: NavHostController,
        showMessage: (String) -> Unit,
    ) {
        NavHost(navController = navHostController, startDestination = "index") {
            composable("index") {
                Index(navHostController)
            }
            composable("card_item") {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    CardItemComponent(
                        item = CardItem(
                            id = 1,
                            title = "Card Title",
                            subtitle = "Card Sub Title",
                            imageUrl = "https://avatars.githubusercontent.com/u/3131608?s=200&v=4"
                        ),
                        actionListener = {
                            showMessage.invoke("ID $it Clicked")
                        }
                    )
                }
            }
            composable("card_item_shimmer") {

            }
            composable("chip") {

            }
            composable("countdown") {

            }
            composable("dial_code_flag_bottom_sheet") {

            }
            composable("dial_code_flag") {

            }
            composable("dial_code_flag_separated") {

            }
            composable("horizontal_card_item") {

            }
            composable("icon_menu") {

            }
            composable("image_banner") {

            }
            composable("other_product_card") {

            }
            composable("otp_text_field") {

            }
            composable("product_card_component") {

            }
            composable("text_shimmer") {

            }
            composable("top_bar_back_button") {

            }
            composable("top_search_action_bar") {

            }
        }
    }

}