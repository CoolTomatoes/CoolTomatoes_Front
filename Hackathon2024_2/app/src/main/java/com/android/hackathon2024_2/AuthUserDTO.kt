package com.android.hackathon2024_2

data class AuthUserDTO(
    val username: String,
    val name: String,
    val major: String,
    val studentGrade: Int,
    val registrationStatus: RegistrationStatus
)
