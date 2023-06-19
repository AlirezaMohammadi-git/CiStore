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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.gameland.R
import com.pixel_alireza.gameland.utils.endPointChooser
import com.pixel_alireza.gameland.utils.stylePrice


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
                .amount.toString() + " " +
                    endPointChooser(gamename = viewModel.storeData.value.name),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(Modifier.padding(vertical = 16.dp))
        Text(
            text = "Hey, let us celebrate Free Fire's 6th Anniversary!\n" +
                    "\n" +
                    "\n" +
                    "[Duo Active Skills in CS-Ranked]\n" +
                    "\n" +
                    "Want to experience the agile movement of the Wukong-Tatsuya combo or the ability to shield yourself while saving a knocked down teammate using the Chrono-Dimitri pair? Play the special Clash Squad mode to explore unlimited possibilities while improving your shooting skills!\n" +
                    "\n" +
                    "\n" +
                    "[Achievement System]\n" +
                    "\n" +
                    "On the occasion of Free Fire's birthday, we want to thank you for your continuous support. You've already created so many memories and achieved so much worth celebrating in Free Fire! We've captured everything in the Achievement System. Head there now to check out your accomplishments!\n" +
                    "\n" +
                    "\n" +
                    "[More Quick Messages]\n" +
                    "\n" +
                    "Now you can pick and choose your favorite quick messages from over 50 options to use in your battles. Plus, this time we added female voice lines!\n" +
                    "\n" +
                    "\n" +
                    "[New Characters]\n" +
                    "\n" +
                    "Awakening Alok is coming soon, and we have a new addition to the family, Sonia, who can turn the tide in critical moments!\n" +
                    "\n" +
                    "\n" +
                    "Free Fire is a world-famous survival shooter game available on mobile. Each 10-minute game places you on a remote island where you are pit against 49 other players, all seeking survival. Players freely choose their starting point with their parachute, and aim to stay in the safe zone for as long as possible. Drive vehicles to explore the vast map, hide in the wild, or become invisible by proning under grass or rifts. Ambush, snipe, survive, there is only one goal: to survive and answer the call of duty.",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light
        )
        Spacer(Modifier.padding(vertical = 16.dp))
        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.onChangeEmail(it) },
            placeholder = { Text(text = "xxx@gmail.com") },
            shape = MaterialTheme.shapes.large,
            label = { Text(text = stringResource(id = R.string.yourGameMail)) }
        )

        OutlinedTextField(
            value = viewModel.gamePass.value,
            onValueChange = { viewModel.onGamePassChange(it) },
            placeholder = { Text(text = stringResource(id = R.string.password)) },
            shape = MaterialTheme.shapes.large,
            label = { Text(text = stringResource(id = R.string.yourGamePass)) },
        )


        OutlinedTextField(
            value = viewModel.gameName.value,
            onValueChange = { viewModel.onGameNameChange(it) },
            placeholder = { Text(text = stringResource(id = R.string.accountName)) },
            shape = MaterialTheme.shapes.large,
            label = { Text(text = stringResource(id = R.string.yourAcountName)) },
        )


        Spacer(modifier = Modifier.padding(top = 16.dp))



        Text(
            text = stringResource(id = R.string.amount) + " : ${stylePrice((viewModel.storeData.value.amount * viewModel.productCount.value).toString())}  ${
                endPointChooser(
                    viewModel.storeData.value.name
                )
            }",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )


        Spacer(modifier = Modifier.padding(top = 16.dp))




        Text(
            text = stringResource(id = R.string.price) + " : ${stylePrice((viewModel.storeData.value.price * viewModel.productCount.value).toString())} Toman",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )


        Spacer(modifier = Modifier.padding(top = 16.dp))


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
                    viewModel.onRemoveProduct()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        null
                    )
                }
                Text(
                    text = "${viewModel.productCount.value}",
                    modifier = Modifier
                )
                IconButton(onClick = {
                    viewModel.onAddMoreProduct()
                }) {
                    Icon(Icons.Default.Add, null)
                }
            }
        }


        Spacer(modifier = Modifier.padding(top = 16.dp))


        Button(
            modifier = Modifier.fillMaxWidth(0.9f),
            onClick = { /*  to do in feature */ }) {
            Text(text = stringResource(id = R.string.purchase), modifier = Modifier.padding(8.dp))
        }

        Spacer(Modifier.padding(vertical = 48.dp))

    }
}