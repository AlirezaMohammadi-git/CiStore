package com.pixel_alireza.gameland.data.remote.repo.user

import android.content.SharedPreferences
import android.util.Log
import com.example.chatapp.utils.Resource
import com.pixel_alireza.gameland.data.local.model.cache.TokenInMemory
import com.pixel_alireza.gameland.data.local.model.cache.UsernameInMemory
import com.pixel_alireza.gameland.data.remote.auth.model.SecretInfo
import com.pixel_alireza.gameland.data.remote.auth.model.SignInResponse
import com.pixel_alireza.gameland.data.remote.auth.model.SignUpResponse
import com.pixel_alireza.gameland.data.remote.auth.model.UpdatePass
import com.pixel_alireza.gameland.data.remote.auth.model.UpdateUsername
import com.pixel_alireza.gameland.data.remote.auth.model.authRequest
import com.pixel_alireza.gameland.utils.TAG
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import javax.inject.Inject

class UserServiceImpl @Inject constructor(
    private val client: HttpClient,
    private val sharedPref: SharedPreferences,
) : UserService {


    private val tokenKey = "token"
    private val emailKey = "email"
    private val loginTime = "loginTime"

    override suspend fun signUp(username: String, email: String, password: String): Boolean {
        return try {
            val res = client.post<SignUpResponse> {
                url(UserService.Endpoints.signUp.url)
                val myObject = authRequest(
                    username, email, password
                )
                contentType(ContentType.Application.Json)
                body = myObject
            }
            Log.e(TAG.Error.tag, "signUp: $res")
            if (res.res) {
                saveUsername(username)
                saveEmail(email)
                signIn(email, password)//for token
                true
            } else {
                Log.e(TAG.Error.tag, "signUp(repo): Something went wrong with server")
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun signIn(email: String, password: String): Boolean {
        return try {
            val res = client.post<SignInResponse> {
                url(UserService.Endpoints.signIn.url)
                val auth = authRequest(
                    email = email, password = password
                )
                contentType(ContentType.Application.Json)
                body = auth
            }
            if (res.res) {
                saveToken(res.token.toString())
                loadFromSharePref()
                val secret = getSecretInfo(TokenInMemory.token ?: "NULL").username
                saveUsername(secret)
                saveEmail(email)
                saveLoginTime(System.currentTimeMillis())
                true
            } else {
                false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun updateUsername(username: String, token: String) {
        try {
            client.post<UpdateUsername> {
                url(UserService.Endpoints.updateUsername.url)
                contentType(ContentType.Application.Json)
                header("Authorization", "Bearer $token")
                body = UpdateUsername(
                    username,
                    getEmail()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override suspend fun updatePass(
        oldPass: String,
        newPass: String,
        email: String
    ): Resource<String> {
        return try {
            val req = client.post<SignUpResponse> {
                url(UserService.Endpoints.updatePass.url)
                contentType(ContentType.Application.Json)
                body = UpdatePass(
                    email,
                    oldPass,
                    newPass
                )
            }
            if (req.res) {
                Resource.Success(req.message)
            } else Resource.Error("server error", data = req.message)
        } catch (e: Exception) {
            Resource.Error(e.message.toString(), e.message.toString())
        }
    }

    override suspend fun authenticate(token: String): HttpStatusCode {
        return try {
            return client.get<HttpStatusCode>(UserService.Endpoints.authenticate.url) {
                header("Authorization", "Bearer $token")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            HttpStatusCode.Unauthorized
        }
    }

    override fun saveToken(token: String) {
        sharedPref.edit().putString(tokenKey, token).apply()
    }

    override fun loadFromSharePref() {
        val token = sharedPref.getString(tokenKey, "NULL")!!
        val username = sharedPref.getString(usernameKey, "NULL")
        if (token == "NULL") TokenInMemory.refreshToken(null) else TokenInMemory.refreshToken(token)
        if (username == "NULL") UsernameInMemory.refreshUsername(null) else UsernameInMemory.refreshUsername(
            username
        )
    }

    override suspend fun getSecretInfo(token: String): SecretInfo {
        return try {
            val res = client.get<SecretInfo> {
                header("Authorization", "Bearer $token")
                url(UserService.Endpoints.secret.url)
            }
            res
        } catch (e: Exception) {
            e.printStackTrace()
            SecretInfo(username = "")
        }

    }

    override fun signOut() {
        sharedPref.edit().clear().apply()
        TokenInMemory.refreshToken(null)
    }

    override fun saveEmail(email: String) {
        sharedPref.edit().putString(emailKey, email).apply()
    }

    override fun getEmail(): String {
        return sharedPref.getString(emailKey, "")!!
    }

    val usernameKey = "GameLandusername"
    override fun saveUsername(username: String) {
        sharedPref.edit().putString(usernameKey, username).apply()
    }

    override fun getUsername(): String {
        return sharedPref.getString(usernameKey, "")!!
    }

    override fun saveLoginTime(time: Long) {
        sharedPref.edit().putLong(loginTime, time).apply()
    }

    override fun getLoginTime(): String {
        return sharedPref.getLong(loginTime, 0L).toString()

    }
}