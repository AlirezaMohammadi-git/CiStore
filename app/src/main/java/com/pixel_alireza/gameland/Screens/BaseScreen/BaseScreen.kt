package com.pixel_alireza.gameland.Screens.BaseScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pixel_alireza.gameland.presentation.BaseScreen.BaseScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    viewModel: BaseScreenViewModel = hiltViewModel<BaseScreenViewModel>(),
    onItemClick: (Int) -> Unit
) {
    var selectedItem = viewModel.selectedItem
    val items = viewModel.items
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(78.dp))

        if (selectedItem.value == 0) {
            TopAppBar(
                title = {
                    Text(
                        text = "Game Land",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 28.sp
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme
                        .colorScheme
                        .surfaceColorAtElevation(3.dp)
                )
            )
        }

        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        if (index == 0) {
                            if (selectedItem.value == 0) {
                                Icon(Icons.Filled.Home, contentDescription = item)
                            } else {
                                Icon(Icons.Outlined.Home, contentDescription = item)
                            }
                        } else if (index == 1) {
                            if (selectedItem.value == 1) {
                                Icon(Icons.Filled.List, contentDescription = item)
                            } else {
                                Icon(Icons.Outlined.List, contentDescription = item)
                            }
                        } else if (index == 2) {
                            if (selectedItem.value == 2) {
                                Icon(Icons.Filled.Person, contentDescription = item)
                            } else {
                                Icon(Icons.Outlined.Person, contentDescription = item)
                            }
                        }
                    },
                    selected = selectedItem.value == index,
                    onClick = {
                        selectedItem.value = index
                        onItemClick.invoke(selectedItem.value)
                    }
                )
            }
        }

    }
}