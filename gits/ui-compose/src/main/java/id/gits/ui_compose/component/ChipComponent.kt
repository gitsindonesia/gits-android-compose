package id.gits.ui_compose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChipComponent(text:String){
    Surface(shape = RoundedCornerShape(70), border = BorderStroke(width = 1.dp, color = Color.Black), elevation = 4.dp) {
           Text(text = text, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
    }
}