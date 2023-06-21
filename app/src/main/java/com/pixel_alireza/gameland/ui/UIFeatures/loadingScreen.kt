package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gameland.R


@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
        ,
        contentAlignment = Alignment.Center
    ) {
        LottieAnimationBuilder(animationAdress = R.raw.iphone_loading)
    }
}