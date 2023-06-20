package com.pixel_alireza.gameland.data.remote.repo.user

import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.model.auth.model.SecretInfo
import com.pixel_alireza.gameland.data.remote.model.auth.model.SignInResponse
import com.pixel_alireza.gameland.data.remote.model.auth.model.SignUpResponse
import com.pixel_alireza.gameland.utils.Constants
import io.ktor.http.HttpStatusCode

interface UserService {
    suspend fun signUp(username: String, email: String, password: String): SignUpResponse
    suspend fun signIn(email: String, password: String): SignInResponse
    suspend fun getSecretInfo(token: String): SecretInfo
    suspend fun updateUsername(username: String, token: String)
    suspend fun authenticate(token: String): HttpStatusCode
    fun saveToken(token: String?)
    fun getToken() : String?
    fun loadFromSharePref()
    fun signOut()
    fun saveEmail(email: String)
    fun getEmail(): String
    fun saveUsername(username: String?)
    fun getUsername(): String
    fun saveLoginTime(time: Long)
    fun getLoginTime(): String
    suspend fun updatePass(oldPass: String, newPass: String, email: String): Resource<String>


    sealed class Endpoints(val url: String) {
        object signUp : Endpoints("${Constants.NORMAL_BASE_URL}/signUp")
        object signIn : Endpoints("${Constants.NORMAL_BASE_URL}/signIn")
        object authenticate : Endpoints("${Constants.NORMAL_BASE_URL}/authenticate")
        object secret : Endpoints("${Constants.NORMAL_BASE_URL}/secret")
        object updateUsername : Endpoints("${Constants.NORMAL_BASE_URL}/updateUsername")
        object updatePass : Endpoints("${Constants.NORMAL_BASE_URL}/updatePass")
    }

}