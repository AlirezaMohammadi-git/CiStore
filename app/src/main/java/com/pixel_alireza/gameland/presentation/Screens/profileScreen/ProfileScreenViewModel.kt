package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.local.model.cache.TokenInMemory
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
import com.pixel_alireza.gameland.utils.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileScreenViewModel @Inject constructor(val userService: UserService) : ViewModel() {
    val emailValue = mutableStateOf(userService.getEmail())
    val username = mutableStateOf(userService.getUsername())
    val passwordValue = mutableStateOf("")
    val confPasswordValue = mutableStateOf("")


    val currentPass = mutableStateOf("")
    val newPass = mutableStateOf("")
    val confirmNewPass = mutableStateOf("")

    fun loadInfo() {
        userService.loadFromSharePref()
        if (TokenInMemory.token != null) {
            emailValue.value = userService.getEmail()
            username.value = userService.getUsername()
        }
    }

    fun signOut() {
        viewModelScope.launch(coroutineExceptionHandler) {
            userService.signOut()
        }
    }

    fun signIn(result: (Boolean) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = userService.signIn(emailValue.value, passwordValue.value)
            if (res) {
                result.invoke(true)
            } else {
                result.invoke(false)
            }

        }
    }

    fun signUp(result: (Boolean) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = userService.signUp(username.value, emailValue.value, passwordValue.value)
            result.invoke(res)
        }
    }

    fun updateUsername(newUsername: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val validToken = userService.authenticate(TokenInMemory.token ?: "NULL")
            if (validToken == HttpStatusCode.Unauthorized) {
                onResult.invoke(false, "your not authenticated")
            } else if (validToken == HttpStatusCode.Accepted) {
                userService.updateUsername(newUsername, TokenInMemory.token ?: "")
                userService.saveUsername(newUsername)
                onResult.invoke(true, "username changed!")
            }
        }
    }

    fun getUsername(): String {
        return userService.getUsername()
    }

    fun updatePass(onResult: (String) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = userService.updatePass(currentPass.value, newPass.value, emailValue.value)
            when (res) {
                is Resource.Error -> {
                    onResult.invoke(res.message ?: "Unknown Error")
                }

                is Resource.Success -> {
                    onResult.invoke(res.data ?: "password updated")
                }
            }
        }
    }
}