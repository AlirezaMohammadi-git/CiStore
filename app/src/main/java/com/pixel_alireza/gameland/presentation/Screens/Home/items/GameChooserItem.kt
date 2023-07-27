package com.pixel_alireza.gameland.presentation.Screens.Home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameland.R
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont



//fixme: make inputs dynamic



@Composable
fun GameChooserItem(
    imageResource1: Int ,
    imageResource2: Int ,
    imageResource3: Int ,
    imageResource4: Int ,
    gameName1 : String ,
    gameName2 : String ,
    gameName3 : String ,
    gameName4 : String ,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.toFloat()
    val cardWidth = screenWidth / 4.5

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until 4) {

            var image = imageResource1
            var game = gameName1

            when(i){
                1 ->{
                    image = imageResource2
                    game = gameName2
                }
                2 ->{
                    image = imageResource3
                    game = gameName3
                }
                3 ->{
                    image = imageResource4
                    game = gameName4
                }
            }

            Card(
                modifier = Modifier
                    .width(cardWidth.dp)
                    .height(cardWidth.dp)

            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Surface(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.25f),
                        color = Color.Black.copy(alpha = 0.5f)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "محصولات بازی",
                                fontSize = 6.sp,
                                color = Color.White,
                                fontFamily = yekanBakhFont
                            )
                            Text(
                                text = game ,
                                color = Color.Yellow,
                                fontSize = 8.sp,
                                fontFamily = yekanBakhFont,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun GameChooserItemPreview() {
    GameChooserItem(
        imageResource1 = R.drawable.ic_asphalt,
        imageResource2 = R.drawable.ic_cod ,
        imageResource3 = R.drawable.ic_freefire ,
        imageResource4 = R.drawable.ic_pubg ,
        gameName1 = "آسفالت" ,
        gameName2 = "کالاف دیوتی موبایل" ,
        gameName3 = "فری فایر" ,
        gameName4 = "پابجی"
    )
}