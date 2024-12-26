package com.android.hackathon2024_2

object JwtProvider {
    private var token: String? = null

    fun setToken(token: String?) {
        JwtProvider.token = token
    }

    fun getToken(): String? {
        return token
    }
}
