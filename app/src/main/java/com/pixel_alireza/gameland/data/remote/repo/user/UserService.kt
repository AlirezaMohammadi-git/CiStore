package com.pixel_alireza.gameland.data.remote.repo.user

import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.remote.auth.model.SecretInfo
import com.pixel_alireza.gameland.utils.NORMAL_BASE_URL
import io.ktor.http.HttpStatusCode

interface UserService {
    suspend fun signUp(username: String, email: String, password: String): Boolean
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun getSecretInfo(token: String): SecretInfo
    suspend fun updateUsername(username: String, token: String)
    suspend fun authenticate(token: String): HttpStatusCode
    fun saveToken(token: String)
    fun loadFromSharePref()
    fun signOut()
    fun saveEmail(email: String)
    fun getEmail(): String
    fun saveUsername(username: String)
    fun getUsername(): String
    fun saveLoginTime(time: Long)
    fun getLoginTime(): String
    suspend fun updatePass(oldPass: String, newPass: String, email: String): Resource<String>


    sealed class Endpoints(val url: String) {
        object signUp : Endpoints("$NORMAL_BASE_URL/signUp")
        object signIn : Endpoints("$NORMAL_BASE_URL/signIn")
        object authenticate : Endpoints("$NORMAL_BASE_URL/authenticate")
        object secret : Endpoints("$NORMAL_BASE_URL/secret")
        object updateUsername : Endpoints("$NORMAL_BASE_URL/updateUsername")
        object updatePass : Endpoints("$NORMAL_BASE_URL/updatePass")
    }

}