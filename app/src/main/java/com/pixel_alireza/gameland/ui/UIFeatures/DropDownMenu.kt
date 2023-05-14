package com.pixel_alireza.gameland.ui.UIFeatures

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier


@Composable
fun GameChooserDropDownMenu(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
    selected: (String) -> Unit
) {
    Box(modifier = Modifier) {
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            DropdownMenuItem(
                text = { Text("CODM") },
                onClick = {
                    selected.invoke("CODM")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("PUBG") },
                onClick = {
                    selected.invoke("PUBG")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("FREEFIRE") },
                onClick = {
                    selected.invoke("FREEFIRE")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("CLASH OF CLANS") },
                onClick = {
                    selected.invoke("CLASH OF CLANS")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("CLASH ROYAL") },
                onClick = {
                    selected.invoke("CLASH ROYAL")
                    expanded.value = false
                },
            )
        }
    }
}


@Composable
fun ModeChooserDropDownMenu(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
    selected: (String) -> Unit
) {
    Box(modifier = Modifier) {
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            DropdownMenuItem(
                text = { Text("Battle Royal | Isolated") },
                onClick = {
                    selected.invoke("Battle Royal | Isolated")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("Alcatraz") },
                onClick = {
                    selected.invoke("Alcatraz")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("Multiplayer | Free for all") },
                onClick = {
                    selected.invoke("Multiplayer | Free for all")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("Multiplayer | Team death mach") },
                onClick = {
                    selected.invoke("Multiplayer | Team death mach")
                    expanded.value = false
                },
            )
            DropdownMenuItem(
                text = { Text("Multiplayer | Knife Only") },
                onClick = {
                    selected.invoke("Multiplayer | Knife Only")
                    expanded.value = false
                },
            )
        }
    }
}











