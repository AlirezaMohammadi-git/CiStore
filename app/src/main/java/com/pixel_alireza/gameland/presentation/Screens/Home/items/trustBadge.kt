package com.pixel_alireza.gameland.presentation.Screens.Home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gameland.R


@Composable
fun TrustBadge(

    mainText : String ,
    secondText : String ,
    icon : Int

) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .clip(shape = MaterialTheme.shapes.extraLarge)
            .padding(16.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = mainText,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = secondText,
                color = Color.DarkGray,
                textAlign = TextAlign.End
            )
        }

        Spacer(Modifier.padding(horizontal = 16.dp))

        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
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