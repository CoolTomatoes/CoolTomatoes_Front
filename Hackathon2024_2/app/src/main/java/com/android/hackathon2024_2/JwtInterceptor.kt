package com.android.hackathon2024_2

import okhttp3.Interceptor
import okhttp3.Response

class JwtInterceptor(private val jwtProvider: () -> String?) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        jwtProvider()?.let { token ->
            request = request.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        }
        return chain.proceed(request)
    }
}