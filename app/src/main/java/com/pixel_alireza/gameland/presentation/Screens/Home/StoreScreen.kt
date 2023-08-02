package com.pixel_alireza.gameland.presentation.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameland.R
import com.pixel_alireza.gameland.data.remote.model.store.StoreData
import com.pixel_alireza.gameland.presentation.Screens.Home.items.DiscountedItem
import com.pixel_alireza.gameland.presentation.Screens.Home.items.GameChooserItem
import com.pixel_alireza.gameland.presentation.Screens.Home.items.ScrollableTitles
import com.pixel_alireza.gameland.presentation.Screens.Home.items.TrustBadge
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


    //fixme : use DisposableEffect instead of LaunchedEffect and dispose get requests
//    LaunchedEffect(key1 = true) {
//        viewModel.getItems(context)
//        viewModel.loading.collect {
//            loading.value = it
//        }
//    }

    //fixme : this line is only for test :
    loading.value = false

    if (loading.value) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LottieAnimationBuilder(animationAdress = R.raw.loading_orange, Modifier.size(68.dp))
        }


    } else {
        LazyColumn{
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

            item {
                ScrollableTitles(onEachCardClicked = {

                }, model = sampleList)
            }


            //////////////////////////////////////////////////////////
            /////////////////////////trust badge//////////////////////////
            //////////////////////////////////////////////////////////


            item {
                LazyRow {
                    item {
                        TrustBadge(
                            stringResource(R.string.Enemad),
                            stringResource(R.string.EnemadBig),
                            R.drawable.verify
                        )
                    }
                    item {
                        TrustBadge(
                            stringResource(R.string.experience),
                            stringResource(R.string.experienceBig),
                            R.drawable.experience
                        )
                    }
                    item {
                        TrustBadge(
                            stringResource(R.string.security),
                            stringResource(R.string.securityBig),
                            R.drawable.security
                        )
                    }
                }
            }

            //////////////////////////////////////////////////////////
            /////////////////////////discounted items//////////////////////////
            //////////////////////////////////////////////////////////


            item {
                Spacer(Modifier.requiredHeight(16.dp))

                Text(
                    text = "تخفیفات جدید",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )

                val storeItems = listOf(
                    StoreData(
                        "۱۰۰۰ سی پی کالاdfghdfghdfgف دیوتی موبایل",
                        24000000,
                        "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hdqwalls.com%2Fdownload%2Fcall-of-duty-mobile-4k-2019-he-2932x2932.jpg&f=1&nofb=1&ipt=c32fd13409c1e312ec2933e6cf1548830436ff0c7c6f9b7bc23d41682769eff3&ipo=images",
                        "klsdjflsfdkj",
                        "fdgfdstg",
                        45000000
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

                LazyRow {
                    items(storeItems.size) {
                        DiscountedItem(storeItems[it])
                    }
                }
            }


            //////////////////////////////////////////////////////////
            /////////////////////////Game Chooser//////////////////////////
            //////////////////////////////////////////////////////////


            item {

                Spacer(Modifier.requiredHeight(16.dp))

                Text(
                    text = "بازی خود را انتخاب کنید",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                )


                Column(

                ) {

                    GameChooserItem(
                        R.drawable.ic_pubg,
                        R.drawable.ic_freefire,
                        R.drawable.ic_cod,
                        R.drawable.ic_asphalt,
                        stringResource(R.string.pubg),
                        stringResource(R.string.freefire),
                        stringResource(R.string.callOfDutyMobile),
                        stringResource(R.string.asphalt),
                    ) { imageResource ->
                        println(imageResource)
                    }


                    GameChooserItem(
                        R.drawable.ic_warzone,
                        R.drawable.ic_eight_ball,
                        R.drawable.genshin,
                        R.drawable.hey_day,
                        stringResource(R.string.warzone),
                        stringResource(R.string.eightBall),
                        stringResource(R.string.genshin),
                        stringResource(R.string.hey_day),
                    ) { imageResource ->
                        println(imageResource)
                    }

                    GameChooserItem(
                        R.drawable.of_clans,
                        R.drawable.calsh_royal,
                        R.drawable.pubg_new_state,
                        R.drawable.roblax,
                        stringResource(R.string.clash_of_clans),
                        stringResource(R.string.clash_royal),
                        stringResource(R.string.pubg_new_state),
                        stringResource(R.string.roblax),
                    ) { imageResource ->
                        println(imageResource)
                    }

                }


            }


            //////////////////////////////////////////////////////////
            /////////////////////////Support//////////////////////////
            //////////////////////////////////////////////////////////


            item {

                Spacer(Modifier.requiredHeight(16.dp))

                Text(
                    text = "پشتیبانی اختصاصی سفارشات",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                )

                Image(
                    painter = painterResource(R.drawable.support),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 16.dp , bottom = 16.dp)
                        .padding(horizontal = 8.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                )

            }


            //////////////////////////////////////////////////////////
            /////////////////////////two squarer picture//////////////////////////
            //////////////////////////////////////////////////////////

            item {

                val screenWidth = LocalConfiguration.current.screenWidthDp.toFloat()
                val cardWidth = screenWidth / 2.2

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_pubg),
                        contentDescription = null,
                        modifier = Modifier.requiredWidth(cardWidth.dp).requiredHeight(cardWidth.dp)
                            .clip(shape = MaterialTheme.shapes.medium)
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_asphalt),
                        contentDescription = null,
                        modifier = Modifier.requiredWidth(cardWidth.dp).requiredHeight(cardWidth.dp)
                            .clip(shape = MaterialTheme.shapes.medium)
                    )
                }

            }

            //////////////////////////////////////////////////////////
            /////////////////////////Big trust badge//////////////////////////
            //////////////////////////////////////////////////////////

            item {
                Image(
                    painter = painterResource(R.drawable.permium),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 16.dp , )
                        .padding(horizontal = 8.dp)
                        .clip(shape = MaterialTheme.shapes.medium)

                )
            }

            //////////////////////////////////////////////////////////
            ////////////////social media links//////////////////////////
            //////////////////////////////////////////////////////////

            item {

                Spacer(Modifier.requiredHeight(16.dp))

                Text(
                    text = "ما را در شبکه های اجتماعی دنبال کنید",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                )


                Card(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp)
                        .padding(8.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(R.drawable.youtube),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.instagram),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.telegram),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.whatsapp),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

            }
        }
    }


}