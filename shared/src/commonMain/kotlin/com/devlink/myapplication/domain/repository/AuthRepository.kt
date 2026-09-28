package com.devlink.myapplication.domain.repository

import com.devlink.myapplication.data.model.AuthResponse

interface AuthRepository {
    suspend fun AuthRegister(email: String, password: String) : AuthResponse
}