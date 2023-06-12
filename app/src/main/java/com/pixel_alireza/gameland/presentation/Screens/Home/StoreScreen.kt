package com.pixel_alireza.gameland.presentation.Screens.Home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pixel_alireza.gameland.ui.UIFeatures.ChipSample
import com.pixel_alireza.gameland.utils.TAG


@SuppressLint("MutableCollectionMutableState")
@Composable
fun StoreScreen(
    viewModel: StoreViewModel = hiltViewModel(),
    onNavigateToProductScreen: (String) -> Unit
) {

    Log.e(TAG.Error.tag, "ProfileScreen: looptest")


    viewModel.getItems(LocalContext.current)
    val chipTemplate = arrayListOf(
        "CALL OF DUTY MOBILE",
        "PUBG MOBILE",
        "FREEFIRE",
        "Clash Of Clans",
        "Clash Royal",
    )
    val selectedStrings = remember { mutableStateListOf<String>() }
    val filteredItems = viewModel.items.value.filter { storeData ->
        if (!selectedStrings.isEmpty()) selectedStrings.any { storeData.name.contains(it) } else true
    }
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            chipTemplate.forEach { game ->
                val isSelected = remember { mutableStateOf(false) }
                ChipSample(
                    selected = isSelected,
                    label = game
                )
                LaunchedEffect(isSelected.value) {
                    if (isSelected.value) {
                        selectedStrings.add(game)
                    } else {
                        selectedStrings.remove(game)
                    }
                }
            }
        }
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {
            items(filteredItems.size) {
                GameCardItems(
                    count = filteredItems[it].count,
                    price = filteredItems[it].price,
                    game = filteredItems[it].name,
                    imageURL = filteredItems[it].imageURL,
                    priority = filteredItems[it].priority,
                    id = filteredItems[it].id,
                    onCardClicked = { storeData ->
                        onNavigateToProductScreen.invoke(storeData.id)
                    }
                )
            }
        }
    }
}