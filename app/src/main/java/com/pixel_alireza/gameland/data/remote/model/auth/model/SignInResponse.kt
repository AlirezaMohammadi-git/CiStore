package com.pixel_alireza.gameland.data.remote.model.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class SignInResponse(
    val res: Boolean,
    val token: String?,
    val message: String?
)