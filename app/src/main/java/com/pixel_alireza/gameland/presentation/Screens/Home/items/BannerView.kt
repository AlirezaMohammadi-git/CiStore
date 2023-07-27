package com.pixel_alireza.gameland.presentation.Screens.Home.items

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.gameland.R


@Composable
fun <T> BannerView(image: T) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(image, imageLoader),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun BannerViewPreview() {

    Column {
        BannerView(
            "https://media.tenor.com/CDA2oKU_vusAAAAM/gif-me.gif",
        )
        BannerView(
            R.drawable.cod_mobile,
        )
    }

}