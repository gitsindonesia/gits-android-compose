package id.gits.ui_compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import id.gits.ui_compose.helper.openSheet

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DialCodeAndFlagSeparatedComponent(onResult: (String) -> Unit) {
//    val lstCountry = JsonHelper.getCountryCode(LocalContext.current).toMutableStateList()

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    val phoneCode = remember { mutableStateOf("+62") }
    val phoneNumber = remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    val maxChar = 13

    Row() {
        TextField(
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            value = phoneCode.value,
            onValueChange = {},
            enabled = false,
            modifier = Modifier
                .clickable {
                    openSheet(scope, sheetState)
                }
                .fillMaxWidth(0.2f)
        )
        TextField(
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            value = phoneNumber.value,
            onValueChange = {
                if (it.length <= maxChar) {
                    phoneNumber.value = it
                }
            },
            placeholder = { Text("phone") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            //Card(shape = RoundedCornerShape(16.dp), elevation = 8.dp) {
            Spacer(modifier = Modifier.padding(16.dp))
            LazyColumn() {
//                items(items = ) { country ->
//                    val dialCode = country.dialCode
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                phoneCode.value = dialCode
//                                closeSheet(scope, sheetState)
//                            }
//                            .padding(16.dp)
//                    ) {
//                        Text(text = dialCode, modifier = Modifier.fillMaxWidth(0.2f))
//                        //Spacer(modifier = Modifier.padding(8.dp))
//                        Text(
//                            text = country.name,
//                            modifier = Modifier
//                                .fillMaxWidth(0.9f)
//                                .padding(horizontal = 4.dp),
//                            overflow = TextOverflow.Ellipsis
//                        )
//                        //Spacer(modifier = Modifier.padding(8.dp))
//                        Text(text = country.flag, modifier = Modifier.fillMaxWidth(0.1f))
//                    }
//                }
            }
        }
    ) {

    }
}
