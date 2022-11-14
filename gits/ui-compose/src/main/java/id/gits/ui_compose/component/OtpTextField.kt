package id.gits.ui_compose.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OtpTextField(
    length: Int,
    onValueChanged: (code: String) -> Unit
) {
    var code: List<Char> by remember { mutableStateOf(listOf()) }
    val focusRequesters: List<FocusRequester> = remember {
        val temp = mutableListOf<FocusRequester>()
        repeat(length) {
            temp.add(FocusRequester())
        }
        temp
    }

    Row(
        modifier = Modifier.height(50.dp)
    ) {
        (0 until length).forEach { index ->
            //val textValue = remember { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .focusRequester(focusRequester = focusRequesters[index]),
                textStyle = MaterialTheme.typography.body2.copy(
                    textAlign = TextAlign.Center
                ),
                singleLine = true,
                value = getValue(code, index),
                onValueChange = { value: String ->
                    if (value.length <= 1) {
                        if (focusRequesters[index].freeFocus()) {
                            val temp = code.toMutableStateList()
                            if (value == "") {
                                if (temp.size > index) {
                                    temp.removeAt(index = index)
                                    code = temp
                                    focusRequesters.getOrNull(index - 1)?.requestFocus()
                                }
                            } else {
                                if (code.size > index) {
                                    temp[index] = value.getOrNull(0) ?: ' '
                                } else {
                                    temp.add(value.getOrNull(0) ?: ' ')
                                    code = temp
                                    focusRequesters.getOrNull(index + 1)?.requestFocus()
                                }
                            }
                        }
                        onValueChanged(
                            code.joinToString(separator = "")
                        )
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

fun getValue(code: List<Char>, index: Int): String {
    return code.getOrNull(index = index)?.takeIf {
        it.isDigit()
    }?.toString() ?: ""
}
