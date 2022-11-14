package id.gits.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun ProductCardComponent() {
    val imageSize = 150.dp
    Card(modifier = Modifier.width(imageSize), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.size(imageSize),
                painter = painterResource(id = android.R.drawable.ic_dialog_info),
                contentDescription = "main image",
                contentScale = ContentScale.Crop
            )
            Surface(
                modifier = Modifier.padding(bottom = 4.dp, top = 8.dp),
                shape = RoundedCornerShape(bottomEnd = 12.dp, topEnd = 12.dp),
                color = Color.Red
            ) {
                Text(
                    text = "Terlaris",
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
            Text(text = "ROSE BRAND Minyak Goreng 2 Liter", modifier = Modifier.padding(4.dp))
            Text(text = "Rp 29.500", modifier = Modifier.padding(4.dp))
            Row() {
                Surface(shape = RoundedCornerShape(4.dp), color = Color.Magenta) {
                    Text(text = "26%", modifier = Modifier.padding(4.dp))
                }
                Text(
                    text = "Rp 40.000",
                    modifier = Modifier.padding(4.dp),
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            }
            Row() {
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "badge")
                Text(text = "Kota Bandung", modifier = Modifier.padding(4.dp))
            }
            Row() {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "rating",
                    tint = Color.Yellow
                )
                Text(text = "5.0", modifier = Modifier.padding(4.dp))
                Text(text = "|", modifier = Modifier.padding(4.dp))
                Text(text = "Terjual 10", modifier = Modifier.padding(4.dp))
            }
            Image(
                painter = painterResource(id = android.R.drawable.ic_media_ff),
                contentDescription = "main image"
            )
            Text(text = "Tiba 8-10 Oct", modifier = Modifier.padding(4.dp))
        }
    }
}