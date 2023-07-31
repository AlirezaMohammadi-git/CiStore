package com.pixel_alireza.gameland.presentation.Screens.CartScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gameland.R
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont
import com.pixel_alireza.gameland.utils.addCurrency
import com.pixel_alireza.gameland.utils.addEndPoint
import com.pixel_alireza.gameland.utils.stylePrice


@Composable
fun CartItem(
    storeData: StoreData
) {

    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp).padding(end = 90.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(storeData.name, fontFamily = yekanBakhFont, fontWeight = FontWeight.Light)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        stylePrice(storeData.coinCount.toString()).addEndPoint(storeData.gameTag),
                        fontSize = 12.sp,
                        modifier = Modifier, textAlign = TextAlign.End,
                        fontWeight = FontWeight.Light
                    )
                    CountCard(storeData.productCount , onAdd = {}, onMines = { })

                    Text(
                        text = stylePrice(storeData.price.toString()).addCurrency(),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start).fillMaxWidth(),
                        fontSize = 16.sp
                    )

                }
            }

            AsyncImage(
                model = storeData.imageURL,
                contentDescription = null,
                modifier = Modifier.size(86.dp)
                    .padding(8.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
            )
        }
    }

}

@Composable
fun CountCard(productCount: Int, onMines: () -> Unit, onAdd: () -> Unit) {
    Card(
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onMines.invoke()
            }) {
                if (productCount == 1) {
                    Icon(Icons.Default.Delete, contentDescription = null)
                } else {
                    Icon(
                        painter = painterResource(R.drawable.ic_minus),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }

            }
            Spacer(Modifier.width(4.dp))
            Text(text = productCount.toString(), fontSize = 14.sp)
            Spacer(Modifier.width(4.dp))
            IconButton(onClick = {
                onAdd.invoke()
            }) {
                Icon(painter = painterResource(R.drawable.ic_plus), contentDescription = null)
            }
        }
    }

}

@Composable
@Preview
fun CartItemPreview() {
    CartItem(
        StoreData(
            name = "سی پی اقتصادی کالاف دیوتی موبایل",
            price = 4500000,
            imageURL = "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fusukcanadanews.com%2Fwp-content%2Fuploads%2F2021%2F02%2F20210220_125624-1024x1024.jpg&f=1&nofb=1&ipt=c1b0b98b5fe40b80a6dc1457a5311c1c4c95be31977bda5785d86b02433f27cb&ipo=images ",
            id = "asdfasdf",
            discountedPrice = 8000000,
            productCount = 1,
            coinCount = 50000,
            gameTag = "#call_of_duty_mobile"
        )
    )
}