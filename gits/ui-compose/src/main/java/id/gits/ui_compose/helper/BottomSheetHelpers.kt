package id.gits.ui_compose.helper

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Kudzoza
 * on 14/11/2022
 **/


@OptIn(ExperimentalMaterialApi::class)
fun openSheet(scope: CoroutineScope, sheetState: ModalBottomSheetState) {
    scope.launch {
        sheetState.show()
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun closeSheet(scope: CoroutineScope, sheetState: ModalBottomSheetState) {
    scope.launch {
        sheetState.hide()
    }
}