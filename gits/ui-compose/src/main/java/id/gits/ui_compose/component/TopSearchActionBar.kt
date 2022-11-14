package id.gits.ui_compose.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun TopSearchActionBar() {
    val query = remember { mutableStateOf("") }
    Surface(color = Color.Green) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                value = query.value,
                onValueChange = {
                    query.value = it
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(4.dp),
                leadingIcon = {
                    Icon(
                        imageVector =
                        Icons.Filled.Search, contentDescription = "icon search"
                    )
                }, placeholder = {
                    Text("Search")
                }, keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                ), shape = RoundedCornerShape(8.dp),
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector =
                        Icons.Filled.Email, contentDescription = "icon inbox"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector =
                        Icons.Filled.Notifications, contentDescription = "icon notif"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector =
                        Icons.Filled.ShoppingCart, contentDescription = "icon cart"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector =
                        Icons.Filled.MoreVert, contentDescription = "icon more"
                    )
                }
            }
        }
    }
}