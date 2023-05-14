package com.pixel_alireza.gameland.Screens.addNewCustom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.pixel_alireza.gameland.Screens.profileScreen.AddressField
import com.pixel_alireza.gameland.ui.UIFeatures.GameChooserDropDownMenu
import com.pixel_alireza.gameland.ui.UIFeatures.ModeChooserDropDownMenu
import com.pixel_alireza.gameland.ui.UIFeatures.MyTopAppBar

@Composable
fun AddNewCustom() {
    Scaffold(
        topBar = {
            MyTopAppBar(
                title = "New Custom",
                firstIcon = Pair(true, Icons.Default.Send),
                secondIcon = Pair(false, Icons.Default.ShoppingCart),
                show = true,
                onFirstIconClicked = {}
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            //game chooser
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Game ", style = MaterialTheme.typography.headlineSmall)
                val remGame = remember {
                    mutableStateOf("CODM")
                }
                val remExpanded = remember {
                    mutableStateOf(false)
                }
                Box(
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GameChooserDropDownMenu(expanded = remExpanded) { selectedGame ->
                            remGame.value = selectedGame
                        }
                        Text(
                            text = remGame.value,
                            modifier = Modifier.padding(start = 16.dp),
                            style = MaterialTheme.typography.labelMedium
                        )
                        IconButton(onClick = { remExpanded.value = true }) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null
                            )
                        }
                    }
                }

            }

            //mode chooser
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Mode ", style = MaterialTheme.typography.headlineSmall)
                val remGame = remember {
                    mutableStateOf("Battle Royal | Isolated")
                }
                val remExpanded = remember {
                    mutableStateOf(false)
                }
                Box(
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ModeChooserDropDownMenu(expanded = remExpanded) { selectedGame ->
                            remGame.value = selectedGame
                        }
                        Text(
                            text = remGame.value,
                            modifier = Modifier.padding(start = 16.dp),
                            style = MaterialTheme.typography.labelMedium
                        )
                        IconButton(onClick = { remExpanded.value = true }) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null
                            )
                        }
                    }
                }

            }

            //private or not
            val checked = remember { mutableStateOf(false) }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Private ", style = MaterialTheme.typography.headlineSmall)

                Switch(
                    modifier = Modifier.semantics { contentDescription = "Demo" },
                    checked = checked.value,
                    onCheckedChange = { checked.value = it })
            }

            //password
            if (checked.value) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val pass = remember {
                        mutableStateOf("")
                    }
                    AddressField(
                        value = pass.value,
                        onValueChange = { pass.value = it },
                        placeHolder = { Text(text = "password") },
                        enabled = true,
                        number = true,
                        isError = true
                    )
                }
            }

            //Description
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val pass = remember {
                    mutableStateOf("")
                }
                AddressField(
                    value = pass.value,
                    onValueChange = { pass.value = it },
                    placeHolder = { Text(text = "Description") },
                    enabled = true,
                    number = false,
                )
            }
        }
    }
}