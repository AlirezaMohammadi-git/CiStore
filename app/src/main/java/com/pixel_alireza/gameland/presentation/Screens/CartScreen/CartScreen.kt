package com.pixel_alireza.gameland.presentation.Screens.CartScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont
import com.pixel_alireza.gameland.utils.GameNames


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    cartScreenViewModel: CartScreenViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("سبد خرید", fontFamily = yekanBakhFont, fontWeight = FontWeight.Bold)
                },
                modifier = Modifier,
            )
        }

    ) { paddingValues ->

        val storeItems = listOf(
            StoreData(
                "۱۰۰۰ سی پی کالاdfghdfghdfgف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                GameNames.CODM,
                "fdgfdstg",
                45000000,
                4,
                50000
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "klsdjflsfdkj",
                "sdfasdfasdf"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "sdfgdfsg",
                "sdfasdfasdf"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "sdfsdfggdfsg",
                "sdfasdfasdf"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "sdfg",
                "sdfasdfasdf"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "sdsdfgfg",
                "sdfasdfasdf"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "sdsdfdfghgfg",
                "sdfasdfasdf"
            ),
            StoreData(
                "۱۰۰۰ سی پی کالاف دیوتی موبایل",
                24000000,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                "sdsdfdfghdfghgfg",
                "sdfasdfasdf"
            ),
        )

        LazyColumn(modifier = Modifier.padding(paddingValues)) {

            item {

                Box(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(0.5f)
                            .align(Alignment.CenterStart),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "  تعداد کالا : ${cartScreenViewModel.totalCount.value}",
                            fontFamily = yekanBakhFont,
                            modifier = Modifier.fillMaxWidth().padding(8.dp),
                            textAlign = TextAlign.Start,
                            color = Color.Gray
                        )

                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    ) {

                        var expanded = remember {
                            mutableStateOf(false)
                        }

                        IconButton(onClick = {
                            expanded.value = true
                        }) {
                            Icon(Icons.Default.MoreVert, contentDescription = null)
                        }
                        DropdownMenu(
                            modifier = Modifier.padding(start = 16.dp),
                            expanded = expanded.value,
                            onDismissRequest = {
                                expanded.value = false
                            },
                        ) {

                            DropdownMenuItem(
                                text = {
                                    Text("حذف همه محصولات")
                                },
                                onClick = {

                                },
                                trailingIcon = {
                                    Icon(Icons.Default.Delete, contentDescription = null)
                                }
                            )

                        }
                    }

                }

            }

            items(storeItems.size) { index ->
                CartItem(storeItems[index])
            }

        }
    }

}


@Composable
@Preview
fun CartScreenPreview() {
    CartScreen()
}