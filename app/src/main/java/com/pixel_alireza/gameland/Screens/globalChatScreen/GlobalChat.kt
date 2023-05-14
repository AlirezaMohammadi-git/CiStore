package com.pixel_alireza.gameland.Screens.globalChatScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gameland.R
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder


@Composable
fun GlobalChat() {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            LottieAnimationBuilder(
                animationAdress = R.raw.newsletter,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(text = "No Message")

        }

    }

}