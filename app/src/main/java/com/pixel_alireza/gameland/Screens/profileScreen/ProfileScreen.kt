package com.pixel_alireza.gameland.Screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen() {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .size(80.dp)
            )

            TextButton(onClick = {}) {
                Text(text = "Edit avatar")
            }

        }


        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier.padding(top = 16.dp)
        ){


            OutlinedTextField(
                value = "username" ,
                onValueChange = {} ,
                enabled = false
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = "email" ,
                onValueChange = {} ,
                enabled = false
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = {}){
                Text(text = "Change password")
            }
            Spacer(Modifier.height(16.dp))
            Button(onClick = {}){
                Text(text = "Log out")
            }

        }


    }


}