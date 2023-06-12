package com.pixel_alireza.gameland.presentation.Screens.ProductScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.gameland.R
import com.pixel_alireza.gameland.utils.endPointChooser


@Composable
fun ProductScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    id: String
) {

    viewModel.loadData(id)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = rememberAsyncImagePainter(viewModel.storeData.value.imageURL),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium)
        )

        Spacer(Modifier.padding(vertical = 16.dp))

        Text(
            text = viewModel
                .storeData
                .value
                .count.toString() + " " +
                    endPointChooser(gamename = viewModel.storeData.value.name),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.padding(vertical = 16.dp))
        Text(
            text = "Description",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light
        )
        Spacer(Modifier.padding(vertical = 16.dp))
        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.onChangeEmail(it) },
            placeholder = { Text(text = "xxx@gmail.com") },
            shape = MaterialTheme.shapes.large,
            label = { Text(text = "your game email") }
        )

        OutlinedTextField(
            value = viewModel.gamePass.value,
            onValueChange = { viewModel.onGamePassChange(it) },
            placeholder = { Text(text = "password") },
            shape = MaterialTheme.shapes.large,
            label = { Text(text = "your game password") },
        )


        OutlinedTextField(
            value = viewModel.gameName.value,
            onValueChange = { viewModel.onGameNameChange(it) },
            placeholder = { Text(text = "game name") },
            shape = MaterialTheme.shapes.large,
            label = { Text(text = "your game name") },
        )


        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*  to do in feature */ }) {
                Text(text = "Purchase")
            }
            Card(
                modifier = Modifier,
                border = BorderStroke(
                    2.dp,
                    MaterialTheme.colorScheme.secondary
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        viewModel::onRemoveProduct.invoke(id)
                    }) {
                        if (viewModel.storeData.value.productCount == 1) Icon(
                            Icons.Default.Delete,
                            null
                        ) else Icon(
                            painter = painterResource(id = R.drawable.ic_minus),
                            null
                        )
                    }
                    Text(
                        text = viewModel.storeData.value.productCount.toString(),
                        modifier = Modifier
                    )
                    IconButton(onClick = {
                        viewModel.onAddMoreProduct(id)
                    }) {
                        Icon(Icons.Default.Add, null)
                    }
                }
            }
        }

        Spacer(Modifier.padding(vertical = 48.dp))

    }
}