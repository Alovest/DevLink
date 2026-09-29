package com.devlink.myapplication.domain.repository.auth

import com.devlink.myapplication.data.model.auth.AuthResponse

interface AuthRepository {
    suspend fun AuthRegisterPasswordAndEmail(email: String, password: String) : AuthResponse
    suspend fun AuthRegisterUsername(username: String): AuthResponse
}