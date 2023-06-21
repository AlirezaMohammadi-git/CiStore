package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gameland.R


@Composable
fun LoadingScreen() {

    Surface (
        modifier = Modifier.fillMaxSize() ,
        color = MaterialTheme.colorScheme.inverseOnSurface
    ) {

        LottieAnimationBuilder(animationAdress = R.raw.loading_orange , Modifier.fillMaxSize())

    }

}