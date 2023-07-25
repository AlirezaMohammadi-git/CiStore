package com.pixel_alireza.gameland.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.gameland.R


val yekanBakhFont = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.yekan_bakh_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
            loadingStrategy = FontLoadingStrategy.Async
        ),
        Font(
            resId = R.font.yekan_bakh_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
            loadingStrategy = FontLoadingStrategy.Async
        ),
        Font(
            resId = R.font.yekan_bakh_extra_black,
            weight = FontWeight.ExtraBold,
            style = FontStyle.Normal,
            loadingStrategy = FontLoadingStrategy.Async
        ),
    )
)