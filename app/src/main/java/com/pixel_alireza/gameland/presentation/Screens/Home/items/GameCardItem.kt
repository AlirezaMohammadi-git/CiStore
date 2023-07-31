package com.pixel_alireza.gameland.presentation.Screens.Home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pixel_alireza.gameland.data.remote.model.store.StoreData


//@Composable
//fun GameCardItems(
//    price: Int,
//    game: String,
//    imageURL: String,
//    id: String,
//    onCardClicked: (StoreData) -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
//            .padding(top = 16.dp)
//            .clickable {
//                onCardClicked.invoke(
//                    StoreData(
//                        name = game,
//                        price = price,
//                        imageURL = imageURL,
//                        gameTag = id,
//                        id = ""
//                    )
//                )
//            }
//    ) {
//        Column(
//            verticalArrangement = Arrangement.SpaceAround,
//            horizontalAlignment = Alignment.Start
//        ) {
//            Image(
//                painter = rememberAsyncImagePainter(imageURL),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .height(200.dp)
//                    .fillMaxWidth()
//            )
//
//            Column(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.Center
//            ) {
//
//                Row {
//                    Text(
//                        text = "$game   |",
//                        style = MaterialTheme.typography.labelLarge,
//                        modifier = Modifier
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                }
//
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    text = price.toString(),
//                    style = MaterialTheme.typography.labelSmall,
//                    modifier = Modifier
//                )
//            }
//
//        }
//
//    }
//}
