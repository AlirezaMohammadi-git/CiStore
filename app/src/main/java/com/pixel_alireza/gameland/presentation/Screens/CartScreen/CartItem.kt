package com.pixel_alireza.gameland.presentation.Screens.CartScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun CartItem (
    imageURL : String ,
    productName : String ,
    price : Int ,
    productCount : Int
){

    Row {
        AsyncImage(
            model = imageURL ,
            contentDescription = null ,
            modifier = Modifier.size(30.dp)
        )

        Column {
            Text(productName)
            Text(productName)
            Text(productName)
            Text(productName)
        }

    }

}

@Composable
@Preview
fun CartItemPreview(){
    CartItem("" , "rdsfag" , 1 , 1)
}