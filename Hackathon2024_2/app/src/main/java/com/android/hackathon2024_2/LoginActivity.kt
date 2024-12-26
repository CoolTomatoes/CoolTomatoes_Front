package com.android.hackathon2024_2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.hackathon2024_2.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var joinQuestionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setWindowInsets(binding)

        binding.loginNextBtn.setOnClickListener {
            val id = binding.etId.text.toString()
            val pw = binding.etPw.text.toString()

            val body = mapOf(
                "id" to id,
                "pw" to pw
            )

            // 로그인 요청
            RetrofitClient.sejongApi.login(body).enqueue(object : Callback<SejongAuthResponse> {
                override fun onResponse(call: Call<SejongAuthResponse>, response: Response<SejongAuthResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        val auth = response.body()?.result
                        if (auth?.isAuth == "true") {
                            val userData = auth.body
                            requestJwtToken(userData, id)
                        } else {
                            showError("아이디나 비밀번호가 일치하지 않습니다.")
                        }
                    } else {
                        showError("네트워크 문제로 로그인하지 못했습니다. 다시 시도하시겠습니까?")
                    }
                }

                override fun onFailure(call: Call<SejongAuthResponse>, t: Throwable) {
                    showError("네트워크 문제로 로그인하지 못했습니다. 다시 시도하시겠습니까?")
                }
            })
        }
    }

    private fun requestJwtToken(userData: SejongAuthResponseResultBodyJson, id: String) {
        // 한국어 상태 값을 영어로 매핑
        val statusMap = mapOf(
            "재학" to RegistrationStatus.ATTENDING,
            "휴학" to RegistrationStatus.TAKEOFFSCHOOL,
            "졸업" to RegistrationStatus.GRADUATE
        )

        // 상태 값을 매핑
        val registrationStatus = statusMap[userData.status]
            ?: throw IllegalArgumentException("Unknown registration status: ${userData.status}")

        // AuthUserDTO 생성
        val userDTO = AuthUserDTO(
            username = id,  // ID를 username으로 사용
            name = userData.name,
            major = userData.major,
            studentGrade = userData.grade,
            registrationStatus = registrationStatus,
        )

        // JWT 요청
        RetrofitClient.userApi.requestJwtToken(userDTO).enqueue(object : Callback<JwtResponse> {
            override fun onResponse(call: Call<JwtResponse>, response: Response<JwtResponse>) {
                if (response.isSuccessful) {
                    // 응답 헤더에서 JWT 추출
                    val authHeader = response.headers().get("Authorization")
                    val token = authHeader?.removePrefix("Bearer ")

                    if (!token.isNullOrEmpty()) {
                        // JWT와 username 저장
                        saveUserData(token, id)
                        JwtProvider.setToken(token)

                        val jwtResponse = response.body()
                        navigateToTestActivity()
                    } else {
                        showError("네트워크 문제로 로그인하지 못했습니다. 다시 시도하시겠습니까?")
                    }
                } else {
                    showError("네트워크 문제로 로그인하지 못했습니다. 다시 시도하시겠습니까?")
                }
            }

            override fun onFailure(call: Call<JwtResponse>, t: Throwable) {
                Log.e("JWT_REQUEST", "JWT 발급 오류", t)
                showError("네트워크 문제로 로그인하지 못했습니다. 다시 시도하시겠습니까?")
            }
        })
    }

    private fun saveUserData(token: String, username: String) {
        val sharedPref = getSharedPreferences("auth", MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("jwt_token", token)
            putString("username", username)
            apply() // 비동기적으로 변경사항을 저장
        }
    }

    private fun navigateToTestActivity() {
        val intent = Intent(this@LoginActivity, TypeTestActivity::class.java)
        startActivity(intent)
        finish()
    }

    // 에러 메시지를 joinQuestionTextView에 표시
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}