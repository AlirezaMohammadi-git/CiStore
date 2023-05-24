package com.pixel_alireza.gameland.presentation.profileScreen

import android.util.Patterns
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun AddressField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable () -> Unit,
    enabled: Boolean,
    number: Boolean,
    supportText: @Composable () -> Unit = {},
    isError: Boolean = false,

    ) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeHolder,
        modifier = Modifier.fillMaxWidth(),
        label = placeHolder,
        shape = MaterialTheme.shapes.large,
        enabled = enabled,
        singleLine = false,
        keyboardOptions = if (number) KeyboardOptions(keyboardType = KeyboardType.Phone) else KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
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


@Composable
fun EmailField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable () -> Unit,
    enabled: Boolean,
    isError: Boolean = false
) {
    OutlinedTextField(value = value,
        onValueChange = { onValueChange.invoke(it) },
        placeholder = placeHolder,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {

            },
        label = placeHolder,
        shape = MaterialTheme.shapes.large,
        enabled = enabled,
        singleLine = false,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        isError = if (isError) {
            if (value.isNotBlank()) {
                !Patterns.EMAIL_ADDRESS.matcher(value).matches()
            } else false
        } else false,
        supportingText = {
            if (value.isNotBlank()) {
                if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
                    Text(text = "invalid email format")
                }
            }
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
        })
}


@Composable
fun UsernameField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable () -> Unit,
    enabled: Boolean,
    isError: Boolean = false
) {
    OutlinedTextField(value = value,
        onValueChange = { onValueChange.invoke(it) },
        placeholder = placeHolder,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {

            },
        label = placeHolder,
        shape = MaterialTheme.shapes.large,
        enabled = enabled,
        singleLine = false,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        isError = if (isError) {
            if (value.isNotBlank()) {
                value.length > 16
            } else false
        } else false,
        supportingText = {
            if (value.isNotBlank()) {
                if (value.length > 16) {
                    Text(text = "${value.length}/16")
                }
            }
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
        })
}


@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable () -> Unit,
    enabled: Boolean,
    supportText: @Composable () -> Unit = {},
    isError: Boolean = true,
    SupportText: @Composable () -> Unit,
    EmptySupportText: @Composable () -> Unit,
    passChar: Int,
    isFocused: MutableState<Boolean>,
    leadingIC: @Composable () -> Unit,
    trailingIC: @Composable () -> Unit,
    visualTransformation: VisualTransformation,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange.invoke(it) },
        placeholder = placeHolder,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged {
                isFocused.value = it.isFocused
            },
        label = placeHolder,
        shape = MaterialTheme.shapes.large,
        enabled = enabled,
        singleLine = false,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        isError = if (isError) {
            if (value.isNotBlank()) {
                value.length < passChar
            } else false
        } else false,
        supportingText = if (value.length + 1 < passChar) SupportText else EmptySupportText,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
        },
        trailingIcon = trailingIC,
        visualTransformation = visualTransformation
    )
}