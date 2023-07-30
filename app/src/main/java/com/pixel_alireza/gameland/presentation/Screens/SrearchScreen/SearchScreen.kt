package com.pixel_alireza.gameland.presentation.Screens.SrearchScreen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameland.R
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.presentation.Screens.Home.items.DiscountedItem


@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

        val storeItems = listOf(
            StoreData(
                "۱۰۰۰ سی پی کالاdfghdfghdfgف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj",
                45000000
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj"
            ),
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            searchBar(viewModel)

            FilteredItemList(storeItems)

        }

    }

}

@Composable
fun FilteredItemList(filteredData: List<StoreData>) {

//    LazyColumn(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        items(count = filteredData.size ){
//            DiscountedItem(
//                filteredData[it]
//            )
//        }
//    }


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier,
        state = rememberLazyGridState(),
        contentPadding = PaddingValues(4.dp),
        content = {
            items(count = filteredData.size) {
                DiscountedItem(
                    filteredData[it]
                )
            }
        }
    )

}


@Composable
fun searchBar(
    searchViewModel: SearchViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth() ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = searchViewModel.searchValue.value,
            onValueChange = {
                searchViewModel::changSearchValue.invoke(it)
            },
            placeholder = {
                stringResource(R.string.searchBar)
            },
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .padding(8.dp),
            shape = MaterialTheme.shapes.large,
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = {
                    //todo : add search engin here
                }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onDone = {
                //todo : add search engin here
            })
        )
    }
}

