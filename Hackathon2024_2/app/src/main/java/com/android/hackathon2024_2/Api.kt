package com.android.hackathon2024_2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SejongApi {
    // 세종대학교 로그인 API
    @POST("/auth?method=ClassicSession")
    fun login(@Body body: Map<String, String>): Call<SejongAuthResponse>
}

interface UserApi {
    @POST("/users/login") // 동일한 엔드포인트로 사용자 정보 전송 및 JWT 토큰 요청
    fun requestJwtToken(@Body userDTO: AuthUserDTO): Call<JwtResponse>
}
