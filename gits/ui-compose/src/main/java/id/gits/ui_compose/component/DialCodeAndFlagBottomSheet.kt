package id.gits.ui_compose.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

data class Country(
    val name: String,
    val dialCode: String,
    val code: String,
    val preferred: Boolean,
    val flag: String
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DialCodeAndFlagComponentBottomSheet(
    scope: CoroutineScope,
    sheetState: ModalBottomSheetState,
    onClick: (Country) -> Unit
) {
//    val lstCountry = JsonHelper.getCountryCode(LocalContext.current).toMutableStateList()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        modifier = Modifier.padding(top = 16.dp),
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
            Spacer(modifier = Modifier.padding(16.dp))
            LazyColumn() {
//                items(items = lstCountry) { country ->
//                    val dialCode = country.dialCode
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                onClick(country)
//                                //phoneCode.value = dialCode
//                                BottomSheetHelper.closeSheet(scope, sheetState)
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
