package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MessageBoxItem(
    isOwnMessage: Boolean,
    username: String,
    messageText: String,
    formattedTime: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = if (isOwnMessage) Alignment.CenterEnd
        else Alignment.CenterStart, modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .background(
                    color = if (isOwnMessage) {
                        Color.Green.copy(alpha = 0.1f)
                    } else Color.Blue.copy(alpha = 0.1f), shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp)
        ) {
            Text(text = username, fontWeight = FontWeight.Bold)
            Text(text = messageText, fontWeight = FontWeight.Normal)
            Text(
                text = formattedTime,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 8.sp,
                modifier = Modifier.align(Alignment.End)
            )

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}