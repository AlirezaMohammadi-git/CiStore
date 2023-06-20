package com.pixel_alireza.gameland.presentation.Screens.profileScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.local.model.cache.TokenInMemory
import com.pixel_alireza.gameland.data.remote.repo.user.UserService
import com.pixel_alireza.gameland.utils.TAG
import com.pixel_alireza.gameland.utils.coroutineExceptionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
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

    private val _toastEvent = MutableSharedFlow<String>() //mutable version
    val toastEvent = _toastEvent.asSharedFlow() //immutable version

    fun loadInfo() {
        userService.loadFromSharePref()
        viewModelScope.launch(coroutineExceptionHandler) {
            if ( TokenInMemory.token != null ){
                emailValue.value = userService.getEmail()
                username.value = userService.getUsername()
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun isTokenNull() : Boolean{
        loadInfo()
        return TokenInMemory.token == null
    }

    fun signOut() {
        viewModelScope.launch(coroutineExceptionHandler) {
            userService.signOut()
        }
    }

    fun signIn(result: (Boolean) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = userService.signIn(emailValue.value, passwordValue.value)
            Log.e(TAG.Error.tag, "signIn: $res", )
            if (res.res){
                result.invoke(true)
            }else{
                _toastEvent.emit(res.message ?: "Unknown error")

                result.invoke(false)
            }
        }
    }

    fun signUp(result: (Boolean) -> Unit) {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = userService.signUp(username.value, emailValue.value, passwordValue.value)
            _toastEvent.emit(res.message)
            result.invoke(res.res)
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

                else -> {}
            }
        }
    }
}