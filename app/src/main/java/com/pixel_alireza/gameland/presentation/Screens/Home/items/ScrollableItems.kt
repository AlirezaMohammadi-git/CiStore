package com.pixel_alireza.gameland.presentation.Screens.Home.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTitles(
    onEachCardClicked: (String) -> Unit,
    model: List<String>
) {


    val pagerState = rememberPagerState(
        initialPage = 1,
        initialPageOffsetFraction = 0f,
        pageCount = { model.size }
    )

    HorizontalPager(
        state = pagerState,
        key = {
            model[it]
        },
    ) { page ->
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            ElevatedCard(
                onClick = { onEachCardClicked.invoke(model[page]) },
                shape = MaterialTheme.shapes.large
            ) {
                AsyncImage(
                    model = model[page],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth(0.95f)
                        .requiredHeight(200.dp)
                )
            }
        }
    }


}

@Composable
@Preview
fun ScrollableTitlesPreview() {

    val testList = listOf(
        "https://i0.wp.com/www.androidsage.com/wp-content/uploads/2019/09/Latest-Call-of-Duty-Mobile-APK-download-from-official-global-release.jpg?fit=1200%2C627&quality=100&ssl=1",
        "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fyoshare.net%2Fwp-content%2Fuploads%2F2020%2F07%2FCall-of-Duty-Mobile-MOD-APK.jpg&f=1&nofb=1&ipt=50f22c175ec237a6d8c6c1a3c74cfbf0293e55389070ac6a60230b8ffcd76375&ipo=images"
    )

    ScrollableTitles(model = testList , onEachCardClicked = {

    })
}