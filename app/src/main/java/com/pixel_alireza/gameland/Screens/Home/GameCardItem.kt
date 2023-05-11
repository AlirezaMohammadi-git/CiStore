package com.pixel_alireza.gameland.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

) {

Column (
    modifier = Modifier
        .padding(top = 78.dp , bottom = 88.dp)
        .verticalScroll(rememberScrollState())
    ,
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
                painter = painterResource(R.drawable.codm),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text( text = "CALL OF DUTY MOBILE" , style = MaterialTheme.typography.labelMedium , modifier = Modifier.padding( 16.dp) )
        }

    }

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
                painter = painterResource(R.drawable.pubg),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text( text = "PUBG MOBILE" , style = MaterialTheme.typography.labelMedium , modifier = Modifier.padding( 16.dp) )
        }

    }

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
                painter = painterResource(R.drawable.freefire),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text( text = "FREE FIRE" , style = MaterialTheme.typography.labelMedium , modifier = Modifier.padding(16.dp) )
        }

    }

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
                painter = painterResource(R.drawable.codm),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text( text = "CALL OF DUTY MOBILE" , style = MaterialTheme.typography.labelMedium , modifier = Modifier.padding(16.dp) )
        }

    }
}

}