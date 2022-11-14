package id.gits.android_compose.example

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/**
 * Created by Kudzoza
 * on 14/11/2022
 **/

@Preview(showSystemUi = true)
@Composable
fun Index(
    navHostController: NavHostController = rememberNavController(),
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Card Item", textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("card_item")
                    }
            )
        }
        item {
            Text(
                text = "Card Item Shimmer",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("card_item_shimmer")
                    }
            )
        }
        item {
            Text(
                text = "Chip",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("chip")
                    }
            )
        }
        item {
            Text(
                text = "Countdown",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("countdown")
                    }
            )
        }
        item {
            Text(
                text = "Dial Code Flag Bottom Sheet",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("dial_code_flag_bottom_sheet")
                    }
            )
        }
        item {
            Text(
                text = "Dial Code Flag",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("dial_code_flag")
                    }
            )
        }
        item {
            Text(
                text = "Dial Code Flag Separated",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("dial_code_flag_separated")
                    }
            )
        }
        item {
            Text(
                text = "Horizontal Card Item",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("horizontal_card_item")
                    }
            )
        }
        item {
            Text(
                text = "Icon Menu",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("icon_menu")
                    }
            )
        }
        item {
            Text(
                text = "Image Banner",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("image_banner")
                    }
            )
        }
        item {

            Text(
                text = "Other Product Card",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("other_product_card")
                    }
            )
        }
        item {
            Text(
                text = "Otp Text Field",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("otp_text_field")
                    }
            )
        }
        item {
            Text(
                text = "Product Card Component",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("product_card_component")
                    }
            )
        }
        item {
            Text(
                text = "Text Shimmer",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("text_shimmer")
                    }
            )
        }
        item {
            Text(
                text = "Top Bar Back Button", textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("top_bar_back_button")
                    }
            )
        }
        item {
            Text(
                text = "Top Search Action Bar",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .clickable {
                        navHostController.navigate("top_search_action_bar")
                    }
            )
        }
    }
}