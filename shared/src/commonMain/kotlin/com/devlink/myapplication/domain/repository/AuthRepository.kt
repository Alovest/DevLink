package com.devlink.myapplication.domain.repository

import com.devlink.myapplication.data.model.AuthResponse

interface AuthRepository {
    suspend fun AuthRegister(username: String, password: String, email: String) : AuthResponse
}