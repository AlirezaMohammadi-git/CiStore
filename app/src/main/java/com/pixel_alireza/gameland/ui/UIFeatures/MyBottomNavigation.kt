@file:OptIn(ExperimentalMaterial3Api::class)

package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pixel_alireza.gameland.data.local.model.UIFeatures.BottomNavItem

@Composable
fun MyBottomNavigation(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClicked: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier
    ) {
        items.forEachIndexed { index, item ->
            val selected = item.rout == backStackEntry.value?.destination?.route
            NavigationBarItem(
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                content = {
                                    if (selected) {
                                        Icon(
                                            imageVector = item.filledIcon,
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = item.outlinedIcon,
                                            contentDescription = null
                                        )
                                    }
                                },
                                badge = {
                                    Badge {
                                        Text(text = item.badgeCount.toString())
                                    }
                                }
                            )
                        } else {
                            if (selected) {
                                Icon(imageVector = item.filledIcon, contentDescription = null)
                            } else {
                                Icon(imageVector = item.outlinedIcon, contentDescription = null)
                            }
                        }

                    }

                },
                selected = selected,
                onClick = { onItemClicked.invoke(item) }
            )
        }
    }
}