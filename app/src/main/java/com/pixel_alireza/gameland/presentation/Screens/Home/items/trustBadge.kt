package com.pixel_alireza.gameland.presentation.Screens.Home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
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
import com.example.gameland.R


@Composable
fun TrustBadge(

    mainText : String ,
    secondText : String ,
    icon : Int

) {
    Card(
        modifier = Modifier
            .clip(shape = MaterialTheme.shapes.small)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(75.dp)
            )
            Spacer(Modifier.padding(horizontal = 8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = mainText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = secondText,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
            }
        }

    }

}

@Composable
@Preview
fun TrustBadgePreview() {
    TrustBadge(
        "نماد اعتماد و مجوز" ,
        "دارای اینماد و مجوز وزارت ارشاد کشور" ,
        R.drawable.ic_checked
    )
}