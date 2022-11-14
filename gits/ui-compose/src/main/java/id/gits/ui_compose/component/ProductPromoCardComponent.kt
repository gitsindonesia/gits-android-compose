package id.gits.ui_compose.component

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Preview(showSystemUi = true)
@Composable
fun ProductPromoCardComponent() {
    val imageSize = 150.dp
    Card(modifier = Modifier.width(imageSize), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (productImage, shopImage, price, shopName, text, timeText) = createRefs()
            Image(
                modifier = Modifier
                    .size(imageSize)
                    .constrainAs(productImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                painter = painterResource(id = R.drawable.ic_dialog_map),
                contentDescription = "main image",
                contentScale = ContentScale.Crop,
            )
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .constrainAs(shopImage) {
                        top.linkTo(productImage.top, margin = 100.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = R.drawable.ic_menu_compass),
                contentDescription = "main image",
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Mechanical Keyboard ID",
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(shopName){
                        top.linkTo(shopImage.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                textAlign = TextAlign.Center
            )

            Text(
                text = "Spesial mulai dari",
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(text){
                        top.linkTo(shopName.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                textAlign = TextAlign.Center
            )

            Text(
                text = "Rp3,5 rb",
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(price){
                        top.linkTo(text.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                textAlign = TextAlign.Center
            )

            Text(
                text = "Sisa 32 Jam",
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(timeText){
                        top.linkTo(price.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                textAlign = TextAlign.Center
            )

//            Text(text = "Rp 29.500", modifier = Modifier.padding(4.dp))
//            Row() {
//                Surface(shape = RoundedCornerShape(4.dp), color = Color.Magenta) {
//                    Text(text = "26%", modifier = Modifier.padding(4.dp))
//                }
//                Text(
//                    text = "Rp 40.000",
//                    modifier = Modifier.padding(4.dp),
//                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
//                )
//            }
//            Row() {
//                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "badge")
//                Text(text = "Kota Bandung", modifier = Modifier.padding(4.dp))
//            }
//            Row() {
//                Icon(
//                    imageVector = Icons.Filled.Star,
//                    contentDescription = "rating",
//                    tint = Color.Yellow
//                )
//                Text(text = "5.0", modifier = Modifier.padding(4.dp))
//                Text(text = "|", modifier = Modifier.padding(4.dp))
//                Text(text = "Terjual 10", modifier = Modifier.padding(4.dp))
//            }
//            Image(
//                painter = painterResource(id = R.drawable.ic_media_ff),
//                contentDescription = "main image"
//            )
//            Text(text = "Tiba 8-10 Oct", modifier = Modifier.padding(4.dp))
        }
    }
}