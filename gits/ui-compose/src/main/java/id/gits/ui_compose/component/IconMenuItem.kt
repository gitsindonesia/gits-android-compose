package id.gits.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun IconMenuItem() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(4.dp)) {
        Image(
            painter = painterResource(id = android.R.drawable.ic_secure),
            contentDescription = "menu1", modifier = Modifier.size(30.dp)
        )
        Text(text = "menu 1", maxLines = 2, modifier = Modifier.padding(top = 8.dp))
    }
}