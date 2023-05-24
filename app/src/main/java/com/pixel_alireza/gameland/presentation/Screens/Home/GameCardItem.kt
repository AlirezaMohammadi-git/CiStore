package com.pixel_alireza.gameland.presentation.Screens.Home

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gameland.R


@Composable
fun GameCardItems(
    cardText: String,
    price: String,
    game: String
) {

Column (
    verticalArrangement = Arrangement.SpaceEvenly ,
    horizontalAlignment = Alignment.CenterHorizontally
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(R.drawable.codm2),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Row {
                    Text(
                        text = "$game   |",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = cardText,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = price,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                )
            }

        }

    }
}

}