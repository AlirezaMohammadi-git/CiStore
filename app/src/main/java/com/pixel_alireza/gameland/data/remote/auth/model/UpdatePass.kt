package com.pixel_alireza.gameland.data.remote.auth.model

import kotlinx.serialization.Serializable


@Serializable
data class UpdatePass(
    val email: String,
    val oldPass: String,
    val newPassword: String
)