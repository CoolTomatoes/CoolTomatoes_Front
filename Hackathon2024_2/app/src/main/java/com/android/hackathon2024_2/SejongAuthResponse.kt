package com.android.hackathon2024_2

import com.google.gson.annotations.SerializedName

data class SejongAuthResponse(
    val msg: String,
    val result: SejongAuthResponseResultJson
)

data class SejongAuthResponseResultJson(
    val authenticator: String,
    val code: String,
    @SerializedName("is_auth")
    val isAuth: String,
    @SerializedName("status_code")
    val statusCode: String,
    val success: String,
    val body: SejongAuthResponseResultBodyJson
)

data class SejongAuthResponseResultBodyJson(
    val name: String,
    val major: String,
    val grade: Int,
    val status: String,
    val nickname : String
)
