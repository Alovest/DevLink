package com.devlink.myapplication.domain.repository

import com.devlink.myapplication.data.model.AuthResponse

interface AuthRepository {
    suspend fun AuthRegisterPasswordAndEmail(email: String, password: String) : AuthResponse
    suspend fun AuthRegisterUsername(username: String): AuthResponse
}