package com.devlink.myapplication.domain.usecase

import com.devlink.myapplication.data.model.AuthResponse
import com.devlink.myapplication.domain.repository.AuthRepository

class AuthRegisterUsernameUsecase(private val repository: AuthRepository) {
    suspend operator fun invoke(username: String): AuthResponse{
        return repository.AuthRegisterUsername(username)
    }
}