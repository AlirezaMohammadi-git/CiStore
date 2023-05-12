package com.pixel_alireza.gameland.Screens.globalScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.pixel_alireza.gameland.data.local.ChipDetail
import com.pixel_alireza.gameland.ui.UIFeatures.BasicRoomItem
import com.pixel_alireza.gameland.ui.UIFeatures.ChipSample


@Composable
fun GlobalScreen(
    onSearchBarClicked: () -> Unit,
    onAddCustomClicked: () -> Unit,
    onItemClicked: () -> Unit,
) {
    val chipTemplate = arrayListOf(
        ChipDetail(
            "Call Of Duty Mobile",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "PUBG Mobile",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "Free Fire",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "Clash Of Clans",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "Clash Royal",
            remember { mutableStateOf(false) }
        ),
    )
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize(),
    ) {


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box( // search bar
                modifier = Modifier
                    .fillMaxWidth(0.9f)
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

            IconButton(
                modifier = Modifier.padding(end = 16.dp),
                onClick = { onAddCustomClicked.invoke() }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }

        }

        LazyRow(
            contentPadding = PaddingValues(bottom = 8.dp, start = 16.dp)
        ) {
            items(chipTemplate.size) {
                ChipSample(selected = chipTemplate[it].state, label = chipTemplate[it].label)
            }
        }


        LazyColumn(
            contentPadding = PaddingValues(bottom = 78.dp)
        ) {
            items(count = 10) {
                BasicRoomItem(
                    id = "Alireza$it",
                    game = "Call Of Duty Mobile",
                    mode = "Alcatraz",
                    isPrivate = true,
                    isFollowed = false
                ) {
                    onItemClicked.invoke()
                }

                Divider(
                    modifier = Modifier,
                    thickness = DividerDefaults.Thickness,
                    color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                )

            }
        }

    }
}

