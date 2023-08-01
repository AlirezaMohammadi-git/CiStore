package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gameland.R
import com.pixel_alireza.gameland.ui.theme.yekanBakhFont


@Composable
fun ProfileItems(
    itemText: String,
    icon: Int,
    lastItem: Boolean = false,
    onItemClickListener: () -> Unit,
) {

    Column(
        modifier = Modifier.clickable {
            onItemClickListener.invoke()
        }
    ) {
        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterStart),
                painter = painterResource(R.drawable.ic_left_arrow),
                contentDescription = null
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.CenterEnd),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = itemText, fontFamily = yekanBakhFont)
                Spacer(Modifier.width(8.dp))
                Icon(
                    painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(38.dp)
                )
            }

        }

        Spacer(Modifier.height(16.dp))

        if (!lastItem) {
            Surface(
                Modifier.height(1.dp).fillMaxWidth().padding(horizontal = 16.dp),
                color = Color.LightGray
            ) {}
        }
    }

}


@Composable
@Preview
fun ProfileItemsPreview() {
    ProfileItems("مدیریت سفارشات", R.drawable.ic_shuffle){

    }
}