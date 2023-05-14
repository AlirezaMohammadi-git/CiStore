@file:OptIn(ExperimentalMaterial3Api::class)

package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTopAppBar(
    title: String,
    firstIcon: Pair<Boolean, ImageVector>,
    secondIcon: Pair<Boolean, ImageVector>,
    show: Boolean,
    onFirstIconClicked: () -> Unit = {},
    onSecondIconClicked: () -> Unit = {},

    ) {
    if (show) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 28.sp
                )
            },
            colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme
                    .colorScheme
                    .surfaceColorAtElevation(3.dp)
            ),
            actions = {
                Row {
                    if (firstIcon.first) {
                        IconButton(onClick = { onFirstIconClicked.invoke() }) {
                            Icon(
                                imageVector = firstIcon.second,
                                contentDescription = null
                            )
                        }
                    }
                    if (secondIcon.first) {
                        IconButton(onClick = { onSecondIconClicked.invoke() }) {
                            Icon(imageVector = secondIcon.second, contentDescription = null)
                        }
                    }
                }
            }
        )
    }
}