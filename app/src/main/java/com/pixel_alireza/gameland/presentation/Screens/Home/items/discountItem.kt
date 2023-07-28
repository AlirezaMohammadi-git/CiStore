package com.pixel_alireza.gameland.presentation.Screens.Home.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont
import com.pixel_alireza.gameland.utils.currency
import com.pixel_alireza.gameland.utils.stylePrice


@Composable
fun DiscountedItem(storeData: StoreData) {

    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.requiredHeight(250.dp).fillMaxWidth(0.5f)
    ) {
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            AsyncImage(
                model = storeData.imageURL,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(120.dp)
                    .clip(shape = MaterialTheme.shapes.large)
            )
            Text(
                text = storeData.name,
                modifier = Modifier.padding(top = 8.dp)
                    .fillMaxWidth(),
                fontFamily = yekanBakhFont,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            )
            Box(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter
            ) {


                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = currency,
                        fontFamily = yekanBakhFont,
                        fontSize = 8.sp,
                        color = MaterialTheme.colorScheme.primary ,
                        modifier = Modifier.padding( start = 4.dp , bottom = 4.dp )
                    )

                    Spacer(Modifier.requiredWidth(4.dp))
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stylePrice(storeData.discountedPrice.toString()),
                            modifier = Modifier,
                            fontFamily = yekanBakhFont,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            textDecoration = TextDecoration.LineThrough,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = stylePrice(storeData.price.toString()),
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontFamily = yekanBakhFont,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }

                }

            }
        }
    }

}

@Composable
@Preview
fun DiscountedItemPreview() {
    DiscountedItem(
        StoreData(
            discountedPrice = 40000,
            name = " سی پی کالاف موبایل",
            price = 400000,
            imageURL = "https://static3.gamerantimages.com/wordpress/wp-content/uploads/2019/11/call-of-duty-mobile-characters-1400x700-2.jpg",
            id = "a;fjklsd"
        )
    )
}