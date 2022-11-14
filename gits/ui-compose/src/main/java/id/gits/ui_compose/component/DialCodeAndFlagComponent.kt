package id.gits.ui_compose.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import id.gits.ui_compose.helper.openSheet
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DialCodeAndFlagComponent(
    dialCode: String,
    scope: CoroutineScope,
    sheetState: ModalBottomSheetState,
    onResult: (String) -> Unit,
) {
    val phoneNumber = remember { mutableStateOf("") }

    val maxChar = 13

    TextField(
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        value = phoneNumber.value,
        onValueChange = {
            if (it.length <= maxChar) {
                phoneNumber.value = it
                onResult(dialCode + it)
            }
        },
        placeholder = { Text("phone") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Button(
                onClick = { openSheet(scope, sheetState) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent
                ),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Text(text = dialCode)
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "icon arrow down"
                )
            }
        }
    )

}
