package com.pixel_alireza.gameland.presentation.Screens.Home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameland.R
import com.pixel_alireza.gameland.presentation.Screens.Home.items.DiscountedItem
import com.pixel_alireza.gameland.presentation.Screens.Home.items.GameCardItems
import com.pixel_alireza.gameland.presentation.Screens.Home.items.ScrollableTitles
import com.pixel_alireza.gameland.presentation.Screens.Home.items.TrustBadge
import com.pixel_alireza.gameland.ui.UIFeatures.ChipSample
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder


@Composable
fun StoreScreen(
    viewModel: StoreViewModel = hiltViewModel(),
    onNavigateToProductScreen: (String) -> Unit
) {

    val context = LocalContext.current

    //region chip templates(disabled)
//    val chipTemplate = arrayListOf(
//        "CALL OF DUTY MOBILE",
//        "PUBG MOBILE",
//        "FREEFIRE",
//        "Clash Of Clans",
//        "Clash Royal",
//    )
//    val selectedStrings = remember { mutableStateListOf<String>() }
//    val filteredItems = viewModel.items.value.filter { storeData ->
//        if (!selectedStrings.isEmpty()) selectedStrings.any { storeData.tag.contains(it) } else true
//    }
    //endregion

    val loading = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = true) {
        viewModel.getItems(context)
        viewModel.loading.collect {
            loading.value = it
        }
    }

    if (loading.value) {

        Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center){
            LottieAnimationBuilder(animationAdress = R.raw.loading_orange, Modifier.size(68.dp))
        }

    } else {
        Column {
            //////////////////////////////////////////////////////////
            ////////////////////chip list(disabled)///////////////////////////
            //////////////////////////////////////////////////////////

            //region Chip list
            //            Row(
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .horizontalScroll(rememberScrollState())
//            ) {
//                chipTemplate.forEach { game ->
//                    val isSelected = remember { mutableStateOf(false) }
//                    ChipSample(
//                        selected = isSelected,
//                        label = game
//                    )
//                    LaunchedEffect(isSelected.value) {
//                        if (isSelected.value) {
//                            selectedStrings.add(game)
//                        } else {
//                            selectedStrings.remove(game)
//                        }
//                    }
//                }
//            }
            //endregion

            //////////////////////////////////////////////////////////
            //////////////////Scrollable items/////////////////////////
            //////////////////////////////////////////////////////////

            val sampleList = listOf(
                "https://images.hdqwalls.com/wallpapers/call-of-duty-mobile-4k-new-dd.jpg",
                "https://i1.wp.com/twinfinite.net/wp-content/uploads/2019/10/Call-of-Duty-Mobile-1.jpg?resize=1000%2C643&ssl=1",
                "https://cdn.4gnews.pt/imagens/free-fire-surpreende-tudo-e-todos-ao-ser-considerado-o-melhor-jogo-mobile-de-2020-og.jpg"
            )

            ScrollableTitles(onEachCardClicked = {

            }, model = sampleList)


            //////////////////////////////////////////////////////////
            /////////////////////////trust badge//////////////////////////
            //////////////////////////////////////////////////////////

            Row {
                TrustBadge(
                    mainText = "adsfjasdffasd",
                    secondText = "asdfasdfasdf",
                    icon = R.drawable.ic_freefire
                )
                TrustBadge(
                    mainText = "asdfasdfasdf",
                    secondText = "asdfasdfasdf",
                    icon = R.drawable.ic_pubg
                )
            }


            //////////////////////////////////////////////////////////
            /////////////////////////discounted items//////////////////////////
            //////////////////////////////////////////////////////////


            Text("New Discounts" , fontSize = 18.sp , fontWeight = FontWeight.Bold)

            LazyRow {
                items(viewModel.items.value.size){
                    DiscountedItem(viewModel.items.value[it])
                }
            }


            //////////////////////////////////////////////////////////
            /////////////////////////Game Chooser//////////////////////////
            //////////////////////////////////////////////////////////







            //////////////////////////////////////////////////////////
            /////////////////////////Support//////////////////////////
            //////////////////////////////////////////////////////////


            //////////////////////////////////////////////////////////
            ////////////////list of main items//////////////////////////
            //////////////////////////////////////////////////////////

//            LazyColumn(
//                modifier = Modifier,
//                contentPadding = PaddingValues(bottom = 8.dp)
//            ) {
//                items(filteredItems.size) {
//                    GameCardItems(
//                        price = filteredItems[it].price,
//                        game = filteredItems[it].name,
//                        imageURL = filteredItems[it].imageURL,
//                        id = filteredItems[it].id,
//                        onCardClicked = { storeData ->
//                            onNavigateToProductScreen.invoke(storeData.id)
//                        }
//                    )
//                }
//            }


        }
    }


}