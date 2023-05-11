package com.pixel_alireza.gameland.Screens.globalScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.pixel_alireza.gameland.ui.UIFeatures.BasicRoomItem


@Composable
fun GlobalScreen(
    onSearchBarClicked: () -> Unit,
    onItemClicked: () -> Unit,
) {

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(),
    ) {


        Box( // search bar
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(vertical = 8.dp)
                .clip(
                    shape = MaterialTheme.shapes.large
                )
                .background(color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
                .clickable {
                    onSearchBarClicked.invoke()
                }
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Search, null, Modifier
                        .padding(start = 16.dp)
                        .padding(8.dp)
                )
                Text("Search", Modifier.padding(start = 8.dp))
            }

        }


        LazyColumn(
            contentPadding = PaddingValues()
        ) {
            items(count = 10) {
                BasicRoomItem(
                    id = "Alireza",
                    game = "Call Of Duty Mobile",
                    mode = "Alcatraz",
                    isPrivate = true,
                    isFollowed = false
                ){
                    onItemClicked.invoke()
                }
            }
        }
    }


}