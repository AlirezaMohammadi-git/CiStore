package com.pixel_alireza.gameland.Screens.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixel_alireza.gameland.data.local.ChipDetail
import com.pixel_alireza.gameland.data.local.ShopDetails
import com.pixel_alireza.gameland.ui.UIFeatures.ChipSample


@Composable
fun HomeScreen() {

    val template = arrayListOf(
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
        ShopDetails(
            "",
            "10,000 CP",
            "10,000,000IR",
            "\n" +
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pulvinar sem semper, dapibus dolor vitae, viverra ex. Sed vel erat ligula. Sed ac tristique mauris. Ut vel diam in lorem venenatis venenatis. Proin rhoncus aliquam iaculis. Praesent mollis auctor magna, sit amet tristique quam pellentesque quis. Cras sed vulputate nisi. Vestibulum vel diam ut dui porta gravida vel quis diam. Duis urna quam, tempor ac elit at, facilisis tincidunt leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sollicitudin orci ut sollicitudin finibus. Nunc vitae convallis lorem. Nunc eget ultricies nisi, a faucibus lorem.\n" +
                    "\n" +
                    "Donec ullamcorper arcu et laoreet vulputate. Etiam iaculis scelerisque tellus in fermentum. Sed lobortis blandit dui, eu dapibus neque egestas id. Nulla id accumsan nisi, vitae mattis erat. Integer eu mi ut nunc pellentesque aliquet. Sed sodales hendrerit elit, ut finibus quam accumsan at. Donec sed hendrerit dolor. Morbi a blandit enim. Sed congue nisi ac diam finibus auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque felis tellus, dignissim eu turpis ut, volutpat tincidunt mauris. Quisque quis lacus vitae diam cursus congue. Aliquam rutrum, eros id mollis lobortis, leo sem tristique diam, in tempor risus dui quis ante. Nunc et porta nisi. Nam blandit erat quis massa congue condimentum. Aliquam erat volutpat.",
            "Call Of Duty Mobile"
        ),
    )
    val chipTemplate = arrayListOf(
        ChipDetail(
            "Call Of Duty Mobile",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "PUBG Mobile",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "Free Fire",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "Clash Of Clans",
            remember { mutableStateOf(false) }
        ),
        ChipDetail(
            "Clash Royal",
            remember { mutableStateOf(false) }
        ),
    )

    Column {
        LazyRow(
            contentPadding = PaddingValues(bottom = 8.dp, start = 16.dp)
        ) {
            items(chipTemplate.size) {
                ChipSample(selected = chipTemplate[it].state, label = chipTemplate[it].label)
            }
        }
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(bottom = 8.dp)
        ) {
            items(template.size) {
                GameCardItems(
                    cardText = template[it].cardText,
                    price = template[it].price,
                    game = template[it].game
                )
            }
        }
    }

}