package id.gits.ui_compose.helper

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target

/**
 * Created by Kudzoza
 * on 14/11/2022
 **/

@Composable
fun LoadPicture(url: String): MutableState<Bitmap?> {
    val bitmapState: MutableState<Bitmap?> = remember { mutableStateOf(null) }

    // show default image while image loads
    if (url.isNotEmpty()) {
        Picasso.get()
            .load(url)
            .resize(1024, 600)
            .onlyScaleDown()
            .into(object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    bitmapState.value = bitmap
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    //WIP
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    //WIP
                }
            })
    }

    return bitmapState
}

@Composable
fun LoadPicture(url: String, imageLoaderInterface: ImageLoaderInterface) {
    LoadPicture(url).value?.let {
        imageLoaderInterface.OnSuccess(bitmap = it.asImageBitmap())
    } ?: imageLoaderInterface.OnLoading()
}

interface ImageLoaderInterface {

    @Composable
    fun OnLoading()

    @Composable
    fun OnSuccess(bitmap: ImageBitmap)

}