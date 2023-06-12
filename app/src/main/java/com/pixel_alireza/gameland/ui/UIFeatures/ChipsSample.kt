@file:OptIn(ExperimentalMaterial3Api::class)

package com.pixel_alireza.gameland.ui.UIFeatures

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixel_alireza.gameland.utils.TAG


@Composable
fun ChipSample(
    selected: MutableState<Boolean>,
    label: String
) {
    Log.d(TAG.Warning.tag, "ChipSample: $label")
    FilterChip(
        modifier = Modifier
            .padding(end = 10.dp),
        selected = selected.value,
        onClick = { selected.value = !selected.value },
        label = { Text(text = label) },
        leadingIcon = if (selected.value) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}