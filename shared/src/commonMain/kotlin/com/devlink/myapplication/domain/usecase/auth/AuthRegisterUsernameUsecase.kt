package com.devlink.myapplication.domain.usecase.auth

import com.devlink.myapplication.data.model.auth.AuthResponse
import com.devlink.myapplication.domain.repository.auth.AuthRepository

class AuthRegisterUsernameUsecase(private val repository: AuthRepository) {
    suspend operator fun invoke(username: String): AuthResponse {
        return repository.AuthRegisterUsername(username)
    }
}