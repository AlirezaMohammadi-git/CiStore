package com.pixel_alireza.gameland.presentation.Screens.CartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gameland.R
import com.pixel_alireza.gameland.ui.UIFeatures.MyTopAppBar
import com.pixel_alireza.gameland.ui.theme.badgeColor
import com.pixel_alireza.gameland.utils.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {

Scaffold(

topBar =  {
    TopAppBar(
        title = {
                Row (
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text("سبد خرید")
                    Spacer(Modifier.padding(horizontal = 8.dp))
                    Surface (
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp)) ,
                        color = badgeColor
                    ){
                        Text("  3   ")
                    }
                }
        } ,
        modifier = Modifier ,
    )
}

) {
    LazyColumn(modifier = Modifier.padding(it)){

    }
}

}


@Composable
@Preview
fun CartScreenPreview() {
    CartScreen()
}