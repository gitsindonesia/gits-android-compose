package id.gits.ui_compose.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TopBarBackButton(navController: NavController) {
    IconButton(onClick = { navController.navigateUp() }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back button")
    }
}