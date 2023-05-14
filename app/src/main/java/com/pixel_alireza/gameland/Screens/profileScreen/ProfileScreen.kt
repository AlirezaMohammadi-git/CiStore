package com.pixel_alireza.gameland.Screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.gameland.R
import com.pixel_alireza.gameland.ui.UIFeatures.LottieAnimationBuilder


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                LottieAnimationBuilder(
                    modifier = Modifier.size(120.dp),
                    animationAdress = R.raw.gradient
                )
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(80.dp)
                        .clip(shape = CircleShape)
                )
            }
            TextButton(onClick = {}) {
                Text(text = "Edit avatar")
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Column {
                AddressField(
                    value = "No Username",
                    onValueChange = {},
                    placeHolder = {
                        Text(text = "Username")
                    },
                    enabled = false,
                    number = false
                )
                TextButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {}) {
                    Text(text = "Edit")
                }
                AddressField(
                    value = "No Email",
                    onValueChange = {},
                    placeHolder = {
                        Text(text = "Email")
                    },
                    enabled = false,
                    number = false
                )
                TextButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {}) {
                    Text(text = "Edit")
                }
                Spacer(Modifier.height(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(0.95f),
                    onClick = {}
                ) {
                    Text(text = "Change password")
                }
                Spacer(Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.95f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                    onClick = {}
                ) {
                    Text(text = "Log out")
                }
                LottieAnimationBuilder(
                    animationAdress = R.raw.pencil_drawing,
                    modifier = Modifier.size(250.dp)
                )
            }
        }
    }
}


@Composable
fun AddressField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable () -> Unit,
    enabled: Boolean,
    number: Boolean,
    supportText: @Composable () -> Unit = {},
    isError: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeHolder,
        modifier = Modifier
            .fillMaxWidth(),
        label = placeHolder,
        shape = MaterialTheme.shapes.large,
        enabled = enabled,
        singleLine = false,
        keyboardOptions = if (number) KeyboardOptions(keyboardType = KeyboardType.Phone) else
            KeyboardOptions(keyboardType = KeyboardType.Text),
        isError = if (isError) {
            if (value.isNotBlank()) {
                value.length > 8
            } else false
        } else false,
        supportingText = {
            if (isError) {
                Text(text = "${value.length}/8")
            }
        },

        )
}
